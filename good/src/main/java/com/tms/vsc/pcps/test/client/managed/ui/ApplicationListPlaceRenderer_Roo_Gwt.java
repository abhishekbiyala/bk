// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package com.tms.vsc.pcps.test.client.managed.ui;

import com.google.gwt.text.shared.AbstractRenderer;
import com.tms.vsc.pcps.test.client.managed.request.ApplicationEntityTypesProcessor;
import com.tms.vsc.pcps.test.client.proxy.TimerProxy;
import com.tms.vsc.pcps.test.client.scaffold.place.ProxyListPlace;

public abstract class ApplicationListPlaceRenderer_Roo_Gwt extends AbstractRenderer<ProxyListPlace> {

    public String render(ProxyListPlace object) {
        return new ApplicationEntityTypesProcessor<String>() {

            @Override
            public void handleTimer(TimerProxy isNull) {
                setResult("Timers");
            }
        }.process(object.getProxyClass());
    }
}
