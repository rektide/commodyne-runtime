package com.voodoowarez.commodyne.init.nodyn;

import org.dynjs.Config;
import org.dynjs.runtime.DynJS;
import org.dynjs.runtime.GlobalObject;
import org.projectodd.nodyn.modules.NpmModuleProvider;

import com.voodoowarez.commodyne.RuntimeInitializer;

public class Npm implements RuntimeInitializer {

	public void prepConfig(Config config) {
	}

	public void initialize(DynJS runtime, Config config) {
		final GlobalObject globalObject = runtime.getExecutionContext().getGlobalObject();
		new NpmModuleProvider(globalObject);
	}

}