package com.tms.vsc.pcps.test.client.scaffold.ioc;

import com.tms.vsc.pcps.test.client.scaffold.ScaffoldMobileApp;
import com.google.gwt.inject.client.GinModules;

@GinModules(value = {ScaffoldModule.class})
public interface MobileInjector extends ScaffoldInjector {

	ScaffoldMobileApp getScaffoldApp();
}
