package com.voodoowarez.commodyne.init.dynjs;

import org.dynjs.Config;
import org.dynjs.runtime.DynJS;
import org.dynjs.runtime.GlobalObject;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.VertxFactory;

import com.voodoowarez.commodyne.RuntimeInitializer;

public class JVertx implements RuntimeInitializer {

	protected Vertx vertx;

	public JVertx(Vertx vertx){
		this.vertx= vertx;
	}

	public JVertx(){
		this(VertxFactory.newVertx());
	}

	public void prepConfig(Config config) {
	}

	public void initialize(DynJS dynjs) {
		final GlobalObject globalObject = dynjs.getExecutionContext().getGlobalObject();
		globalObject.defineReadOnlyGlobalProperty("__jvertex", this.vertx);
	}
}
