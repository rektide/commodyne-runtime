package com.voodoowarez.commodyne.init.dynjs;

import org.dynjs.Config;
import org.dynjs.runtime.DynJS;
import org.dynjs.runtime.GlobalObject;

import com.voodoowarez.commodyne.RuntimeInitializer;

public class StdFds implements RuntimeInitializer {

	public void prepConfig(Config config) {
	}

	public void initialize(DynJS dynjs) {
		final GlobalObject globalObject = dynjs.getExecutionContext().getGlobalObject();
		globalObject.defineReadOnlyGlobalProperty("stdout", System.out);
		globalObject.defineReadOnlyGlobalProperty("stderr", System.err);
	}
}
