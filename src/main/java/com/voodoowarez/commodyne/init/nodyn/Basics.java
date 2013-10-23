package com.voodoowarez.commodyne.init.nodyn;

import org.dynjs.Config;
import org.dynjs.runtime.DynJS;
import org.dynjs.runtime.DynObject;
import org.dynjs.runtime.GlobalObject;
import org.projectodd.nodyn.buffer.BufferType;
import org.projectodd.nodyn.util.QueryString;

import com.voodoowarez.commodyne.RuntimeInitializer;

public class Basics implements RuntimeInitializer {

	public void initialize(DynJS runtime, Config config) {
		final GlobalObject globalObject = runtime.getExecutionContext().getGlobalObject();
		final DynObject node = new DynObject(globalObject);

		final BufferType bufferType = new BufferType(globalObject);
		node.put("buffer", bufferType);

		node.put("QueryString", new QueryString(globalObject));

		globalObject.defineGlobalProperty("nodyn", node);
		globalObject.defineGlobalProperty("global", globalObject);
		globalObject.defineGlobalProperty("__filename", "repl");
	}

	public void prepConfig(Config config) {
	}
}