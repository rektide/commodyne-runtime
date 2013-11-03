package com.voodoowarez.commodyne.init;

import org.dynjs.Config;

import com.voodoowarez.commodyne.RuntimeInitializer;

public class MultiRuntimeInitializerRunner implements RuntimeInitializer {

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

	static public RuntimeInitializer[] concat(RuntimeInitializer[]... initses){
		int len= 0;
		for(RuntimeInitializer[] inits : initses){
			len += inits.length;
		}
		RuntimeInitializer[] agg= new RuntimeInitializer[len];
		len = 0;
		for(RuntimeInitializer[] inits : initses){
			System.arraycopy(inits, 0, agg, len, inits.length);
			len += inits.length;
		}
		return agg;
	}
}
