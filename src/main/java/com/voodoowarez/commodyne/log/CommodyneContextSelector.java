package com.voodoowarez.commodyne.log;

import org.apache.logging.log4j.core.LoggerContext;

public class CommodyneContextSelector extends SingletonContextSelector {

	protected static LoggerContext LOGGER_CONTEXT = new CommodyneLoggerContext(CommodyneContextSelector.class.getSimpleName());

	public CommodyneContextSelector() {
		super(LOGGER_CONTEXT);
	}
}
