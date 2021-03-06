package edu.mum.cs.cs525.labs.exercises.lab06;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleLoggerAdapterImpl implements SimpleLoggerAdapter {
	private static final Map<Class<?>, SimpleLoggerAdapter> INSTANCE_MAP = 
			Collections.synchronizedMap(new HashMap<Class<?>, SimpleLoggerAdapter>());
	
	private Logger logger;


	
	private SimpleLoggerAdapterImpl(Logger logger) {
		super();
		this.logger = logger;
	}
	
	public static SimpleLoggerAdapter getInstance(Class<?> clazz){
		SimpleLoggerAdapter adapter = INSTANCE_MAP.get(clazz);
		if(null == adapter) {
			synchronized(SimpleLoggerAdapterImpl.class) {
				adapter = INSTANCE_MAP.get(clazz);
				if(null == adapter) {
					adapter = new SimpleLoggerAdapterImpl(LogManager.getLogger(clazz));
					INSTANCE_MAP.put(clazz, adapter);
				}
			}
		}

		
		return adapter;
	}

	public void log(LogLevel logLevel, String message) {
		Level level;
		switch(logLevel) {
		case ERROR:
			level = Level.ERROR;
			break;
		case WARNING:
			level = Level.WARN;
			break;
		case INFO:
			level = Level.INFO;
			break;
		default: 
			level = Level.INFO;
			break;
		}
		
		logger.log(level, message);
		
	}

}
