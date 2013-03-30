package com.tms.vsc.pcps.test.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.tms.vsc.pcps.test.client.managed.request.ApplicationEntityTypesProcessor;
import com.tms.vsc.pcps.test.client.managed.request.ApplicationRequestFactory;
import com.tms.vsc.pcps.test.client.managed.ui.TimerListView;
import com.tms.vsc.pcps.test.client.managed.ui.TimerMobileListView;
import com.tms.vsc.pcps.test.client.proxy.TimerProxy;
import com.tms.vsc.pcps.test.client.scaffold.ScaffoldApp;
import com.tms.vsc.pcps.test.client.scaffold.place.ProxyListPlace;

public final class ApplicationMasterActivities extends ApplicationMasterActivities_Roo_Gwt {

    @Inject
    public ApplicationMasterActivities(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }
}
