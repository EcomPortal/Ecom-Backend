package com.ecom.app.service;

public interface EmailServiceVM {

	void sendNewWelcomeLetter(String subject, String email, String defaultPass, String name);
}
