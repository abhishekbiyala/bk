package com.tms.vsc.pcps.test.client.managed.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.tms.vsc.pcps.test.client.managed.request.ApplicationRequestFactory;
import com.tms.vsc.pcps.test.client.proxy.TimerProxy;
import com.tms.vsc.pcps.test.client.scaffold.activity.IsScaffoldMobileActivity;
import com.tms.vsc.pcps.test.client.scaffold.place.ProxyDetailsView;
import com.tms.vsc.pcps.test.client.scaffold.place.ProxyListPlace;
import com.tms.vsc.pcps.test.client.scaffold.place.ProxyPlace;
import com.tms.vsc.pcps.test.client.scaffold.place.ProxyPlace.Operation;
import java.util.Set;

public class TimerDetailsActivity extends TimerDetailsActivity_Roo_Gwt {

    public TimerDetailsActivity(EntityProxyId<com.tms.vsc.pcps.test.client.proxy.TimerProxy> proxyId, ApplicationRequestFactory requests, PlaceController placeController, ProxyDetailsView<com.tms.vsc.pcps.test.client.proxy.TimerProxy> view) {
        this.placeController = placeController;
        this.proxyId = proxyId;
        this.requests = requests;
        view.setDelegate(this);
        this.view = view;
    }

    public void editClicked() {
        placeController.goTo(getEditButtonPlace());
    }

    public Place getBackButtonPlace() {
        return new ProxyListPlace(TimerProxy.class);
    }

    public String getBackButtonText() {
        return "Back";
    }

    public Place getEditButtonPlace() {
        return new ProxyPlace(view.getValue().stableId(), Operation.EDIT);
    }

    public String getTitleText() {
        return "View Timer";
    }

    public boolean hasEditButton() {
        return true;
    }

    public void onCancel() {
        onStop();
    }

    public void onStop() {
        display = null;
    }

    public void start(AcceptsOneWidget displayIn, EventBus eventBus) {
        this.display = displayIn;
        Receiver<EntityProxy> callback = new Receiver<EntityProxy>() {

            public void onSuccess(EntityProxy proxy) {
                if (proxy == null) {
                    placeController.goTo(getBackButtonPlace());
                    return;
                }
                if (display == null) {
                    return;
                }
                view.setValue((TimerProxy) proxy);
                display.setWidget(view);
            }
        };
        find(callback);
    }
}
