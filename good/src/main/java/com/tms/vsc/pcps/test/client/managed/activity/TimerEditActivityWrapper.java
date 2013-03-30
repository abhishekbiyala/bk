package com.tms.vsc.pcps.test.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.tms.vsc.pcps.test.client.managed.request.ApplicationRequestFactory;
import com.tms.vsc.pcps.test.client.proxy.TimerProxy;
import com.tms.vsc.pcps.test.client.scaffold.activity.IsScaffoldMobileActivity;
import com.tms.vsc.pcps.test.client.scaffold.place.ProxyEditView;
import com.tms.vsc.pcps.test.client.scaffold.place.ProxyListPlace;
import com.tms.vsc.pcps.test.client.scaffold.place.ProxyPlace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TimerEditActivityWrapper extends TimerEditActivityWrapper_Roo_Gwt {

    private final EntityProxyId<TimerProxy> proxyId;

    public TimerEditActivityWrapper(ApplicationRequestFactory requests, View<?> view, Activity activity, EntityProxyId<com.tms.vsc.pcps.test.client.proxy.TimerProxy> proxyId) {
        this.requests = requests;
        this.view = view;
        this.wrapped = activity;
        this.proxyId = proxyId;
    }

    public Place getBackButtonPlace() {
        return (proxyId == null) ? new ProxyListPlace(TimerProxy.class) : new ProxyPlace(proxyId, ProxyPlace.Operation.DETAILS);
    }

    public String getBackButtonText() {
        return "Cancel";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return (proxyId == null) ? "New Timer" : "Edit Timer";
    }

    public boolean hasEditButton() {
        return false;
    }

    @Override
    public String mayStop() {
        return wrapped.mayStop();
    }

    @Override
    public void onCancel() {
        wrapped.onCancel();
    }

    @Override
    public void onStop() {
        wrapped.onStop();
    }

    public interface View<V extends com.tms.vsc.pcps.test.client.scaffold.place.ProxyEditView<com.tms.vsc.pcps.test.client.proxy.TimerProxy, V>> extends ProxyEditView<TimerProxy, V> {
    }
}
