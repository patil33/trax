package com.trackz.utils;

public interface EmailService {
	public void sendSimpleMessage(
		      String to, String subject, String text);
}
