package com.tms.vsc.pcps.test.client.managed.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.Editor.Ignore;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.ValueAwareEditor;
import com.google.gwt.editor.client.adapters.EditorSource;
import com.google.gwt.editor.client.adapters.ListEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.tms.vsc.pcps.test.client.managed.ui.TimerListEditor.NameLabel;
import com.tms.vsc.pcps.test.client.proxy.TimerProxy;
import com.tms.vsc.pcps.test.client.scaffold.ui.CollectionRenderer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TimerListEditor extends TimerListEditor_Roo_Gwt {

    @UiField
    FlowPanel container;

    @UiField(provided = true)
    @Ignore
    ValueListBox<TimerProxy> picker = new ValueListBox<TimerProxy>(com.tms.vsc.pcps.test.client.managed.ui.TimerProxyRenderer.instance(), new com.google.web.bindery.requestfactory.gwt.ui.client.EntityProxyKeyProvider<TimerProxy>());

    @UiField
    Button add;

    @UiField
    HTMLPanel editorPanel;

    @UiField
    Button clickToEdit;

    @UiField
    HTMLPanel viewPanel;

    @UiField
    Label viewLabel;

    @UiField
    Style style;

    boolean editing = false;

    private List<TimerProxy> values;

    private final List<TimerProxy> displayedList;

    public TimerListEditor() {
        initWidget(GWT.<Binder>create(Binder.class).createAndBindUi(this));
        Driver driver = GWT.<Driver>create(Driver.class);
        ListEditor<TimerProxy, NameLabel> listEditor = ListEditor.of(new NameLabelSource());
        driver.initialize(listEditor);
        driver.display(new ArrayList<TimerProxy>());
        displayedList = listEditor.getList();
        editing = false;
    }

    @UiHandler("add")
    public void addClicked(ClickEvent e) {
        if (picker.getValue() == null) {
            return;
        }
        for (TimerProxy proxy : displayedList) {
            if (proxy.getMessage().equals(picker.getValue().getMessage())) {
                return;
            }
        }
        displayedList.add(picker.getValue());
        viewLabel.setText(makeFlatList(displayedList));
    }

    @UiHandler("clickToEdit")
    public void clickToEditClicked(ClickEvent e) {
        toggleEditorMode();
    }

    @Override
    public void flush() {
    }

    @Override
    public List<com.tms.vsc.pcps.test.client.proxy.TimerProxy> getValue() {
        if (values == null && displayedList.size() == 0) {
            return null;
        }
        return new ArrayList<TimerProxy>(displayedList);
    }

    public void onLoad() {
        makeEditable(false);
    }

    @Override
    public void onPropertyChange(String... strings) {
    }

    public void setAcceptableValues(Collection<com.tms.vsc.pcps.test.client.proxy.TimerProxy> proxies) {
        picker.setAcceptableValues(proxies);
    }

    @Override
    public void setDelegate(EditorDelegate<java.util.List<com.tms.vsc.pcps.test.client.proxy.TimerProxy>> editorDelegate) {
    }

    @Override
    public void setValue(List<com.tms.vsc.pcps.test.client.proxy.TimerProxy> values) {
        this.values = values;
        makeEditable(editing = false);
        if (displayedList != null) {
            displayedList.clear();
            if (values != null) {
                for (TimerProxy e : values) {
                    displayedList.add(e);
                }
            }
        }
        viewLabel.setText(makeFlatList(values));
    }

    private void makeEditable(boolean editable) {
        if (editable) {
            editorPanel.setStylePrimaryName(style.editorPanelVisible());
            viewPanel.setStylePrimaryName(style.viewPanelHidden());
            clickToEdit.setText("Done");
        } else {
            editorPanel.setStylePrimaryName(style.editorPanelHidden());
            viewPanel.setStylePrimaryName(style.viewPanelVisible());
            clickToEdit.setText("Edit");
        }
    }

    private String makeFlatList(Collection<com.tms.vsc.pcps.test.client.proxy.TimerProxy> values) {
        return CollectionRenderer.of(com.tms.vsc.pcps.test.client.managed.ui.TimerProxyRenderer.instance()).render(values);
    }

    private void toggleEditorMode() {
        editing = !editing;
        makeEditable(editing);
    }

    interface Binder extends UiBinder<Widget, TimerListEditor> {
    }

    interface Driver extends RequestFactoryEditorDriver<List<TimerProxy>, ListEditor<TimerProxy, NameLabel>> {
    }

    class NameLabel extends Composite implements LeafValueEditor<TimerProxy> {

        final Label messageEditor = new Label();

        private TimerProxy proxy = null;

        public NameLabel() {
            this(null);
        }

        public NameLabel(EventBus eventBus) {
            initWidget(messageEditor);
        }

        public void setValue(TimerProxy proxy) {
            this.proxy = proxy;
            messageEditor.setText(com.tms.vsc.pcps.test.client.managed.ui.TimerProxyRenderer.instance().render(proxy));
        }

        @Override
        public TimerProxy getValue() {
            return proxy;
        }
    }

    interface Style extends CssResource {

        String editorPanelHidden();

        String editorPanelVisible();

        String viewPanelHidden();

        String viewPanelVisible();
    }

    private class NameLabelSource extends EditorSource<NameLabel> {

        @Override
        public NameLabel create(int index) {
            NameLabel label = new NameLabel();
            container.insert(label, index);
            return label;
        }

        @Override
        public void dispose(NameLabel subEditor) {
            subEditor.removeFromParent();
        }

        @Override
        public void setIndex(NameLabel editor, int index) {
            container.insert(editor, index);
        }
    }
}
