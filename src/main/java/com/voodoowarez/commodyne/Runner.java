package com.voodoowarez.commodyne;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.dynjs.Config;
import org.dynjs.cli.Arguments;
import org.dynjs.cli.Repl;
import org.dynjs.runtime.DynJS;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import com.google.common.base.Supplier;
import com.voodoowarez.commodyne.init.Nodyn;

public class Runner {

	protected InputStream inputStream;
	protected PrintStream outputStream;
	protected Arguments args = null;
	protected Config config = null;
	protected DynJS runtime = null;
	protected RuntimeInitializer[] initializers;

	static public Supplier<Arguments> DEFAULT_ARGUMENT_SUPPLIER = new Supplier<Arguments>(){
		public Arguments get() {
			return new NodynArguments();
		}};

	static public Supplier<PrintStream> DEFAULT_OUTPUT_STREAM = new Supplier<PrintStream>(){
		public PrintStream get() {
			return System.out;
		}};

	static public Supplier<InputStream> DEFAULT_INPUT_STREAM = new Supplier<InputStream>(){
		public InputStream get() {
			return System.in;
		}};

	static public Supplier<RuntimeInitializer[]> DEFAULT_RUNTIME_INITIALIZER = new Supplier<RuntimeInitializer[]>(){
		public RuntimeInitializer[] get() {
			return new RuntimeInitializer[] {new Nodyn()};
		}};

	public Runner(RuntimeInitializer[] initializers, InputStream inputStream, PrintStream outputStream) {
		this.inputStream = inputStream == null && DEFAULT_INPUT_STREAM != null ? DEFAULT_INPUT_STREAM.get() : inputStream;
		this.outputStream = outputStream == null && DEFAULT_OUTPUT_STREAM != null ? DEFAULT_OUTPUT_STREAM.get() : outputStream;
		this.initializers = initializers == null && DEFAULT_RUNTIME_INITIALIZER != null ? DEFAULT_RUNTIME_INITIALIZER.get() : initializers;
	};

	public static void main(String[] args) throws IOException {
		try {
			new Runner(null, null, null).run(args);
		} catch (CmdLineException e) {
			throw new IOException(e);
		}
	}

	public void run(String[] args) throws CmdLineException, IOException {
		run(parseArguments(args, null));
	}

	public void run(Arguments args) throws CmdLineException, IOException {
		this.args = args;
		this.config = buildConfiguration();
		this.runtime = buildRuntime(this.config);
		initialize();
		launch();
	}

	public DynJS makeRuntime() {
		return buildRuntime(buildConfiguration());
	}

	public Config buildConfiguration() {
		final Config config = this.args != null ? this.args.getConfig() : new Config();
		config.setOutputStream(this.outputStream);
		return config;
	}

	static public DynJS buildRuntime(final Config config) {
		return new DynJS(config);
	}

	public static Arguments parseArguments(String[] args, Arguments target) throws CmdLineException {
		if(target == null)
			target = DEFAULT_ARGUMENT_SUPPLIER.get();

		final CmdLineParser parser = new CmdLineParser(target);
		parser.setUsageWidth(80);
		parser.parseArgument(args);
		return target;
	}

	public void initialize() {
		initialize(this.runtime, this.initializers);
	}

	static public void initialize(DynJS dynjs, RuntimeInitializer[] initializers) {
		for(RuntimeInitializer initializer : initializers){
			initializer.initialize(dynjs);
		}
	}

	public void launch() throws IOException {
		this.launch(this.runtime, this.args, this.inputStream, this.outputStream);
	}

	public void launch(DynJS dynjs, Arguments args, InputStream in, PrintStream out) throws IOException {
		if (args.isHelp() || args.isEmpty()) {
			printHelp(out, true);
		} else if (args.getFilename() != null) {
			executeFile(dynjs, args.getFilename());
		} else if (args.isConsole()) {
			startRepl(dynjs, in, out);
		} else if (args.isVersion()) {
			printHelp(out, false);
		}
	}

	private Object executeFile(DynJS runtime, String filename) throws IOException {
		return runtime.newRunner().withSource(new File(filename)).execute();
	}

	private Repl startRepl(DynJS runtime, InputStream in, PrintStream out) {
		final Repl repl = new Repl(runtime, in, out, "Welcome to commodyn. ^D to exit.", "> ", System.getProperty("user.dir") + "/nodyn.log");
		repl.run();
		return repl;
	}

	public void printHelp(PrintStream out, boolean usage) {
		out.println(showVersion());
		if(!usage)
			return;
		final String usages[] = this.showUsages();
		for(String use : usages){
			out.println(use);
		}
	}

	public String showVersion() {
		return "dynjs " + DynJS.VERSION;
	}

	public String[] showUsages() {
		return new String[] {"--console\t?",
			"--debug\tenter debug mode",
			"--help\tprint help and exit",
			"--version\tprint version and exit",
			"FILE\t\tfile to execute"};
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public PrintStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(PrintStream outputStream) {
		this.outputStream = outputStream;
	}

	public RuntimeInitializer[] getInitializers() {
		return initializers;
	}

	public void setInitializers(RuntimeInitializer[] initializers) {
		this.initializers = initializers;
	}
}
