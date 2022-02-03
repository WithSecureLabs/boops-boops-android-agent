package com.boops.jdiesel.api.sessions;

import com.boops.jdiesel.api.connectors.Connector.Status;
import com.boops.jdiesel.api.links.Link;
import com.boops.jdiesel.connection.AbstractSession;
import com.boops.jdiesel.connection.AbstractSessionCollection;

public class SessionCollection extends AbstractSessionCollection {
	
	private Link connector = null;
//	private SessionServiceConnection session_service_connection = null;
	
	public SessionCollection(Link connector) {
		this.connector = connector;
//		this.session_service_connection = new SessionServiceConnection();
		
//		SessionService.startAndBindToService(Agent.getInstance().getMercuryContext(), this.session_service_connection);
	}
	
	@Override
	public Session create() {
		return (Session)this.storeSession(new Session(this.connector));
	}
	
//	public SessionServiceConnection getSessionService() {
//		return this.session_service_connection;
//	}
	
	@Override
	public void onSessionStarted(AbstractSession session) {
		this.connector.setStatus(Status.ACTIVE);
		
//		this.getSessionService().notifySessionStarted(session.getSessionId());
	}
	
	@Override
	public void onSessionStopped(AbstractSession session) {
//		this.getSessionService().notifySessionStopped(session.getSessionId());
		this.connector.setStatus(Status.ONLINE);
		
		if(!this.any())
			this.connector.lastSessionStopped();
	}
	
}
