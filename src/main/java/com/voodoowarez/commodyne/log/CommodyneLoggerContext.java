package com.voodoowarez.commodyne.log;

import java.net.URI;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.async.AsyncLoggerContext;
import org.apache.logging.log4j.message.MessageFactory;

public class CommodyneLoggerContext extends AsyncLoggerContext {

	public CommodyneLoggerContext(final String name) {
		super(name);
	}

	public CommodyneLoggerContext(final String name, final Object externalContext) {
		super(name, externalContext);
	}

	public CommodyneLoggerContext(final String name, final Object externalContext, final URI configLocn) {
		super(name, externalContext, configLocn);
	}

	public CommodyneLoggerContext(final String name, final Object externalContext, final String configLocn) {
		super(name, externalContext, configLocn);
	}

	protected Logger newInstance(final LoggerContext ctx, final String name, final MessageFactory messageFactory) {
		return new CommodyneLogger(ctx, name, messageFactory);
	}
}
