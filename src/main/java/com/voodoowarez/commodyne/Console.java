package com.voodoowarez.commodyne;

public interface Console {
	void info(String msg);
	void error(String msg);
	void trace(String msg, Throwable ex);
}
