package com.appspot.ssg.android.server;

public class ServerRequestException extends Exception{

	private final String message;

	public ServerRequestException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
