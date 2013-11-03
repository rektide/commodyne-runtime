package com.voodoowarez.commodyne.init;

import org.dynjs.Config;
import org.dynjs.runtime.DynJS;

import com.voodoowarez.commodyne.RuntimeInitializer;
import com.voodoowarez.commodyne.init.dynjs.JVertx;

public class DynJS extends MultiRuntimeInitializerRunner {

	public static RuntimeInitializer[] INITIALIZERS = new RuntimeInitializer[] { new JVertx() };

	public DynJS(RuntimeInitializer[] initializers) {
		super(INITIALIZERS);
	}
}