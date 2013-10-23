package com.voodoowarez.commodyne.init.nodyn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.dynjs.Config;
import org.dynjs.runtime.DynJS;

import com.voodoowarez.commodyne.RuntimeInitializer;

public class LastJsJs implements RuntimeInitializer {

	public void prepConfig(Config config) {
	}

	public void initialize(DynJS runtime, Config config) {
		InputStream is = runtime.getConfig().getClassLoader().getResourceAsStream("node.js");
		if (is != null) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			runtime.newRunner().withSource(reader).evaluate();
			try {
				is.close();
			} catch (IOException e) {
			}
		} else {
			System.err.println("[ERROR] Cannot initialize Nodyn.");
		}
	}

}