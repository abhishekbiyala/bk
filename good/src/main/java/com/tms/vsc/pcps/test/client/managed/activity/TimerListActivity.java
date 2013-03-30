package com.tms.vsc.pcps.test.client.managed.activity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.view.client.Range;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.tms.vsc.pcps.test.client.managed.request.ApplicationRequestFactory;
import com.tms.vsc.pcps.test.client.proxy.TimerProxy;
import com.tms.vsc.pcps.test.client.scaffold.ScaffoldMobileApp;
import com.tms.vsc.pcps.test.client.scaffold.activity.IsScaffoldMobileActivity;
import com.tms.vsc.pcps.test.client.scaffold.place.AbstractProxyListActivity;
import com.tms.vsc.pcps.test.client.scaffold.place.ProxyListView;
import java.util.List;

public class TimerListActivity extends TimerListActivity_Roo_Gwt {

    public TimerListActivity(ApplicationRequestFactory requests, ProxyListView<com.tms.vsc.pcps.test.client.proxy.TimerProxy> view, PlaceController placeController) {
        super(placeController, view, TimerProxy.class);
        this.requests = requests;
    }

    public Place getBackButtonPlace() {
        return ScaffoldMobileApp.ROOT_PLACE;
    }

    public String getBackButtonText() {
        return "Entities";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return "Timers";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<com.tms.vsc.pcps.test.client.proxy.TimerProxy>> createRangeRequest(Range range) {
        return requests.timerRequest().findTimerEntries(range.getStart(), range.getLength());
    }
}
