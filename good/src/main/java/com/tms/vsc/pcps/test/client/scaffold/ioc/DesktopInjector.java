package com.tms.vsc.pcps.test.client.scaffold.ioc;

import com.tms.vsc.pcps.test.client.scaffold.ScaffoldDesktopApp;
import com.google.gwt.inject.client.GinModules;

@GinModules(value = {ScaffoldModule.class})
public interface DesktopInjector extends ScaffoldInjector {

	ScaffoldDesktopApp getScaffoldApp();
}