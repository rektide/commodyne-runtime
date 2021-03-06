package com.voodoowarez.commodyne.init.nodyn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.dynjs.Config;
import org.dynjs.runtime.DynJS;

import com.voodoowarez.commodyne.RuntimeInitializer;

public class DynNodeJs implements RuntimeInitializer {

	public void prepConfig(Config config) {
	}

	public void initialize(DynJS runtime) {
		InputStream is = runtime.getConfig().getClassLoader().getResourceAsStream("node.js");
		if (is != null) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			runtime.newRunner().withSource(reader).evaluate();
			try {
				is.close();
			} catch (IOException e) {
				System.err.println("Cannot load DynJS's node.js scripts; "+e.getMessage());
			}
		} else {
			System.err.println("[ERROR] Cannot initialize Nodyn.");
		}
	}

}