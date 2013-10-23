package com.voodoowarez.commodyne.log;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.async.AsyncLogger;
import org.apache.logging.log4j.message.MessageFactory;

import com.voodoowarez.commodyne.Console;

public class CommodyneLogger extends AsyncLogger implements Console {

	public CommodyneLogger(LoggerContext context, String name, MessageFactory messageFactory) {
		super(context, name, messageFactory);
	}
}
