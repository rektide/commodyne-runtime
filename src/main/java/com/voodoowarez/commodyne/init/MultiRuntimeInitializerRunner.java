package com.voodoowarez.commodyne.init;

import org.dynjs.Config;

import com.voodoowarez.commodyne.RuntimeInitializer;

abstract public class MultiRuntimeInitializerRunner implements RuntimeInitializer {

	protected RuntimeInitializer[] initializers;

	public MultiRuntimeInitializerRunner(RuntimeInitializer[] initializers){
		this.initializers = initializers;
	}

	public void prepConfig(Config config) {
		for(RuntimeInitializer init : initializers) {
			init.prepConfig(config);
		}
	}

	public void initialize(org.dynjs.runtime.DynJS dynjs) {
		for(RuntimeInitializer init : initializers) {
			init.initialize(dynjs);
		}
	}
}
