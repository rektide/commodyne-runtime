package com.voodoowarez.commodyne.init;

import org.dynjs.Config;
import org.dynjs.runtime.DynJS;

import com.voodoowarez.commodyne.RuntimeInitializer;
import com.voodoowarez.commodyne.init.nodyn.Basics;
import com.voodoowarez.commodyne.init.nodyn.LastJsJs;
import com.voodoowarez.commodyne.init.nodyn.Npm;

public class Nodyn implements RuntimeInitializer {

	private static RuntimeInitializer[] initializers = new RuntimeInitializer[] { new Basics(), new Npm(), new LastJsJs() };

	public void prepConfig(Config config) {
		for(RuntimeInitializer init : initializers) {
			init.prepConfig(config);
		}
	}

	public void initialize(DynJS dynjs) {
		for(RuntimeInitializer init : initializers) {
			init.initialize(dynjs);
		}
	}

}