package com.tms.vsc.pcps.test.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.tms.vsc.pcps.test.client.managed.request.ApplicationRequestFactory;
import com.tms.vsc.pcps.test.client.managed.ui.TimerDetailsView;
import com.tms.vsc.pcps.test.client.managed.ui.TimerEditView;
import com.tms.vsc.pcps.test.client.managed.ui.TimerListView;
import com.tms.vsc.pcps.test.client.managed.ui.TimerMobileDetailsView;
import com.tms.vsc.pcps.test.client.managed.ui.TimerMobileEditView;
import com.tms.vsc.pcps.test.client.proxy.TimerProxy;
import com.tms.vsc.pcps.test.client.request.TimerRequest;
import com.tms.vsc.pcps.test.client.scaffold.ScaffoldApp;
import com.tms.vsc.pcps.test.client.scaffold.place.CreateAndEditProxy;
import com.tms.vsc.pcps.test.client.scaffold.place.FindAndEditProxy;
import com.tms.vsc.pcps.test.client.scaffold.place.ProxyPlace;

public class TimerActivitiesMapper extends TimerActivitiesMapper_Roo_Gwt {

    public TimerActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new TimerDetailsActivity((EntityProxyId<TimerProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? TimerMobileDetailsView.instance() : TimerDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
