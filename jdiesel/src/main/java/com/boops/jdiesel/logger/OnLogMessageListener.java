package com.boops.jdiesel.logger;

public interface OnLogMessageListener<T> {
	
	public void onLogMessage(Logger<T> logger, LogMessage message);

}
