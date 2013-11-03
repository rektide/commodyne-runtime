package com.voodoowarez.commodyne.init;

import com.voodoowarez.commodyne.RuntimeInitializer;
import com.voodoowarez.commodyne.init.nodyn.Global;
import com.voodoowarez.commodyne.init.nodyn.DynNodeJs;
import com.voodoowarez.commodyne.init.nodyn.Npm;

public class Nodyn extends MultiRuntimeInitializerRunner {

	public static RuntimeInitializer[]
	  NODYN = new RuntimeInitializer[] { new Global(), new Npm(), new DynNodeJs() },
	  INITIALIZERS = MultiRuntimeInitializerRunner.concat(DynJS.INITIALIZERS, NODYN);

	public Nodyn() {
		super(INITIALIZERS);
	}
}