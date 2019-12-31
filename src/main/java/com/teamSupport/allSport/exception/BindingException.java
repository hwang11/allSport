package com.teamSupport.allSport.exception;

import org.springframework.http.HttpStatus;

public class BindingException extends AbstractEbloBaseException{
private static final long serialVersionUID = 1L;
    
    public BindingException() {
        super();
    }
 
    public BindingException(String msg) {
        super(msg);
    }
 
    public BindingException(Throwable e) {
        super(e);
    }
 
    public BindingException(String errorMessge, Throwable e) {
        super(errorMessge, e);
    }
 
    public HttpStatus getHttpStatus() {
		return HttpStatus.BAD_REQUEST;
	}
}
