// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package com.tms.vsc.pcps.test.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.tms.vsc.pcps.test.client.managed.activity.TimerEditActivityWrapper.View;
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

public abstract class TimerEditActivityWrapper_Roo_Gwt implements Activity, IsScaffoldMobileActivity {

    protected Activity wrapped;

    protected View<?> view;

    protected ApplicationRequestFactory requests;

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        wrapped.start(display, eventBus);
    }
}
