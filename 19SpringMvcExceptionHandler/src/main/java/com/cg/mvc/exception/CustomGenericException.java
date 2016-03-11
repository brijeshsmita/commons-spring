package com.cg.mvc.exception;
public class CustomGenericException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String errCode;
	private String errMsg;
	public CustomGenericException(){
		
	}
	public CustomGenericException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	//getters and setters and toString()
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	@Override
	public String toString() {
		return "CustomGenericException [errCode=" + errCode + ", errMsg="
				+ errMsg + "]";
	}	
}