package com.appspot.ssg.android.server;

public class ServerRequestException extends Exception{

	private static final long serialVersionUID = 4263071021646975387L;
	private final String message;

	public ServerRequestException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
