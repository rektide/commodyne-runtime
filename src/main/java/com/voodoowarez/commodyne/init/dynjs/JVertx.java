package com.voodoowarez.commodyne.init.dynjs;

import org.dynjs.Config;
import org.dynjs.runtime.DynJS;
import org.dynjs.runtime.GlobalObject;
import org.vertx.java.core.Vertx;
import org.vertx.java.platform.Container;

import com.voodoowarez.commodyne.RuntimeInitializer;

public class JVertx implements RuntimeInitializer {

	protected Container container;
	protected Vertx vertx;

	public JVertx(Vertx vertx, Container container){
		this.vertx= vertx;
		this.container= container;
	}

	public void prepConfig(Config config) {
	}

	public void initialize(DynJS dynjs) {
		final GlobalObject globalObject = dynjs.getExecutionContext().getGlobalObject();
		globalObject.defineReadOnlyGlobalProperty("__jvertex", this.vertx);
		globalObject.defineReadOnlyGlobalProperty("__jcontainer", this.container);
	}
}
