package edu.mum.cs.cs525.labs.exercises.lab06;

public class Application {
	private static final SimpleLoggerAdapter LOGGER =
			SimpleLoggerAdapterImpl.getInstance(Application.class);
	
	public static void main(String[] args) {
		LOGGER.log(LogLevel.ERROR, "Entering application.");
	}

}
