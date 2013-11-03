package com.voodoowarez.commodyne.init;

import com.voodoowarez.commodyne.RuntimeInitializer;
import com.voodoowarez.commodyne.init.nodyn.Global;
import com.voodoowarez.commodyne.init.nodyn.DynNodeJs;
import com.voodoowarez.commodyne.init.nodyn.Npm;

public class Nodyn extends MultiRuntimeInitializerRunner {

	private static RuntimeInitializer[] INITIALIZERS = new RuntimeInitializer[] { new Global(), new Npm(), new DynNodeJs() };

	public Nodyn(RuntimeInitializer[] initializers) {
		super(INITIALIZERS);
	}
}