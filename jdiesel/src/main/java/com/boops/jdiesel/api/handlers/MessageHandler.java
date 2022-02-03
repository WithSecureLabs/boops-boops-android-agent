package com.boops.jdiesel.api.handlers;

import com.boops.jdiesel.api.InvalidMessageException;
import com.boops.jdiesel.api.Protobuf.Message;

public interface MessageHandler {
	
	public Message handle(Message message) throws InvalidMessageException;
	
}
