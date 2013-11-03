package com.voodoowarez.commodyne.init.nodyn;

import org.dynjs.Config;
import org.dynjs.runtime.DynJS;
import org.dynjs.runtime.GlobalObject;

import com.voodoowarez.commodyne.RuntimeInitializer;

public class Filename implements RuntimeInitializer {

	protected String filename;

	public Filename(String filename){
		this.filename= filename;
	}

	public void initialize(final DynJS runtime) {
		final GlobalObject globalObject = runtime.getExecutionContext().getGlobalObject();
		globalObject.defineGlobalProperty("__filename", this.filename);
	}

	public void prepConfig(Config config) {
	}
}