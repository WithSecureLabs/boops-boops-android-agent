package com.boops.jdiesel.connection;

public interface SecureConnection {

	public String getHostCertificateFingerprint();
	public String getPeerCertificateFingerprint();
	
}
