package com.voodoowarez.commodyne;

import org.dynjs.cli.Arguments;
import org.kohsuke.args4j.Option;

class NodynArguments extends Arguments {
	static final String CLUSTERED = "--clustered";

	@Option(name = NodynArguments.CLUSTERED, usage = "run a clustered instance on the localhost")
	private boolean isClustered = false;

	public boolean isClustered() {
		return isClustered;
	}
}