package com.voodoowarez.commodyne;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.dynjs.Config;

public interface Main {
	void initialize(Config config);
	void execute(String source) throws IOException;
	void startRepl(InputStream input, PrintStream output);
	String showVersion();
	String[] showUsages();
}
