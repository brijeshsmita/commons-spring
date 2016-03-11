 package com.cg.exception;

public class EmsException extends Exception {
	
	private static final long serialVersionUID = -8152785786197763358L;
	private String message;
	public EmsException() {
		super();
	}
	public EmsException(String message) {
		super(message);
		this.message=message;
	}
	@Override
	public String toString() {
		return "EmsException [message=" + message + "]";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}//end of class
