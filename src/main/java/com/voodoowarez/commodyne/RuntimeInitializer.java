package com.voodoowarez.commodyne;

import org.dynjs.Config;
import org.dynjs.cli.Arguments;
import org.dynjs.runtime.DynJS;

public interface RuntimeInitializer {
	void prepConfig(Config config);
	void initialize(DynJS dynjs);
}
