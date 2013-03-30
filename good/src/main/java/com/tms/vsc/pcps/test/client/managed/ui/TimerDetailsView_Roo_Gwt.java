// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package com.tms.vsc.pcps.test.client.managed.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.tms.vsc.pcps.test.client.proxy.TimerProxy;
import com.tms.vsc.pcps.test.client.scaffold.place.ProxyDetailsView;
import com.tms.vsc.pcps.test.client.scaffold.place.ProxyListView;

public abstract class TimerDetailsView_Roo_Gwt extends Composite implements ProxyDetailsView<TimerProxy> {

    @UiField
    SpanElement id;

    @UiField
    SpanElement message;

    @UiField
    SpanElement version;

    TimerProxy proxy;

    @UiField
    SpanElement displayRenderer;

    public void setValue(TimerProxy proxy) {
        this.proxy = proxy;
        id.setInnerText(proxy.getId() == null ? "" : String.valueOf(proxy.getId()));
        message.setInnerText(proxy.getMessage() == null ? "" : String.valueOf(proxy.getMessage()));
        version.setInnerText(proxy.getVersion() == null ? "" : String.valueOf(proxy.getVersion()));
        displayRenderer.setInnerText(TimerProxyRenderer.instance().render(proxy));
    }
}
