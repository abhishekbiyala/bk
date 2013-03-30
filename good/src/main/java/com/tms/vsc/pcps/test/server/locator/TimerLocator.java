package com.tms.vsc.pcps.test.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import com.tms.vsc.pcps.test.Timer;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("com.tms.vsc.pcps.test.Timer")
@Component
public class TimerLocator extends Locator<Timer, Long> {

    public Timer create(Class<? extends com.tms.vsc.pcps.test.Timer> clazz) {
        return new Timer();
    }

    public Timer find(Class<? extends com.tms.vsc.pcps.test.Timer> clazz, Long id) {
        return Timer.findTimer(id);
    }

    public Class<com.tms.vsc.pcps.test.Timer> getDomainType() {
        return Timer.class;
    }

    public Long getId(Timer timer) {
        return timer.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Timer timer) {
        return timer.getVersion();
    }
}
