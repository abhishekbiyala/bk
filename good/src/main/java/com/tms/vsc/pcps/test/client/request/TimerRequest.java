// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package com.tms.vsc.pcps.test.client.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("com.tms.vsc.pcps.test.Timer")
@ServiceName("com.tms.vsc.pcps.test.Timer")
public interface TimerRequest extends RequestContext {

    abstract Request<java.lang.Long> countTimers();

    abstract Request<java.util.List<com.tms.vsc.pcps.test.client.proxy.TimerProxy>> findAllTimers();

    abstract Request<java.util.List<com.tms.vsc.pcps.test.client.proxy.TimerProxy>> findTimerEntries(int firstResult, int maxResults);

    abstract Request<com.tms.vsc.pcps.test.client.proxy.TimerProxy> findTimer(Long id);

    abstract InstanceRequest<com.tms.vsc.pcps.test.client.proxy.TimerProxy, java.lang.Void> persist();

    abstract InstanceRequest<com.tms.vsc.pcps.test.client.proxy.TimerProxy, java.lang.Void> remove();
}
