package com.tms.vsc.pcps.test.client.scaffold.ioc;

import com.tms.vsc.pcps.test.client.scaffold.ScaffoldApp;
import com.google.gwt.inject.client.Ginjector;

public interface ScaffoldInjector extends Ginjector {

	ScaffoldApp getScaffoldApp();
}
