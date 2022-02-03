package com.boops.jdiesel.api.sessions;

import android.os.Looper;

import com.boops.jdiesel.api.InvalidMessageException;
import com.boops.jdiesel.api.Protobuf.Message;
import com.boops.jdiesel.api.handlers.MessageHandler;
import com.boops.jdiesel.api.handlers.ReflectionMessageHandler;
import com.boops.jdiesel.api.links.Link;
import com.boops.jdiesel.connection.AbstractSession;
import com.boops.jdiesel.reflection.ObjectStore;

public class Session extends AbstractSession {
	
	private Link connector = null;
	public ObjectStore object_store = new ObjectStore();
	private MessageHandler reflection_message_handler = new ReflectionMessageHandler(this);
	
	public Session(Link connector) {
		super();
		
		this.connector = connector;
	}
	
	protected Session(String session_id) {
		super(session_id);
	}
	
	public static Session nullSession() {
		return new Session("null");
	}
	
	@Override
	protected Message handleMessage(Message message) throws InvalidMessageException {
		return this.reflection_message_handler.handle(message);
	}
	
	@Override
	public void run(){
		Looper.prepare();
		
		super.run();
	}
	
	@Override
	public void send(Message message) {
		this.connector.send(message);
	}

}
