package com.voodoowarez.commodyne.init;

import com.voodoowarez.commodyne.RuntimeInitializer;
import com.voodoowarez.commodyne.init.nodyn.Global;
import com.voodoowarez.commodyne.init.nodyn.DynNodeJs;
import com.voodoowarez.commodyne.init.nodyn.Npm;

public class Nodyn extends MultiRuntimeInitializerRunner {

	static {
		final RuntimeInitializer[] inits = new RuntimeInitializer[DynJS.INITIALIZERS.length+Nodyn.INITIALIZERS.length];
		System.arraycopy(DynJS.INITIALIZERS, 0, inits, 0, DynJS.INITIALIZERS.length);
		System.arraycopy(Nodyn.INITIALIZERS, 0, inits, 0, Nodyn.INITIALIZERS.length);
		INITIALIZERS = inits;
	}
	private static RuntimeInitializer[] INITIALIZERS = new RuntimeInitializer[] { new Global(), new Npm(), new DynNodeJs() };

	public Nodyn(RuntimeInitializer[] initializers) {
		super(INITIALIZERS);
	}
}