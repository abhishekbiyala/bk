package com.tms.vsc.pcps.test.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import com.tms.vsc.pcps.test.client.proxy.TimerProxy;

public class TimerProxyRenderer extends ProxyRenderer<TimerProxy> {

    private static com.tms.vsc.pcps.test.client.managed.ui.TimerProxyRenderer INSTANCE;

    protected TimerProxyRenderer() {
        super(new String[] { "message" });
    }

    public static com.tms.vsc.pcps.test.client.managed.ui.TimerProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new TimerProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(TimerProxy object) {
        if (object == null) {
            return "";
        }
        return object.getMessage() + " (" + object.getMessage() + ")";
    }
}
