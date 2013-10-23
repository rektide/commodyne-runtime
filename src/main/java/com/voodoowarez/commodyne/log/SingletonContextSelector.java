package com.voodoowarez.commodyne.log;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.selector.ContextSelector;

/** a reusable copy of AsyncLoggerContext */
abstract public class SingletonContextSelector implements ContextSelector {

	protected LoggerContext context;

	public SingletonContextSelector(LoggerContext context){
		this.context = context;
	}

	public LoggerContext getContext(final String fqcn, final ClassLoader loader, final boolean currentContext) {
		return this.context;
	}

	public List<LoggerContext> getLoggerContexts() {
		final List<LoggerContext> list = new ArrayList<LoggerContext>();
		list.add(this.context);
		return Collections.unmodifiableList(list);
	}

	public LoggerContext getContext(final String fqcn, final ClassLoader loader, final boolean currentContext, final URI configLocation) {
		return this.context;
	}

	public void removeContext(final LoggerContext context) {
	}
}
