// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package com.tms.vsc.pcps.test.client.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "com.tms.vsc.pcps.test.Timer", locator = "com.tms.vsc.pcps.test.server.locator.TimerLocator")
@RooGwtProxy(value = "com.tms.vsc.pcps.test.Timer", readOnly = { "version", "id" }, scaffold = true)
public interface TimerProxy extends EntityProxy {

    abstract Long getId();

    abstract String getMessage();

    abstract void setMessage(String message);

    abstract Integer getVersion();
}
