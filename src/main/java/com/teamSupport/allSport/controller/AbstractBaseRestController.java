package com.teamSupport.allSport.controller;

import java.net.BindException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.teamSupport.allSport.dto.ResponseMessage;
import com.teamSupport.allSport.exception.AbstractEbloBaseException;
import com.teamSupport.allSport.exception.BindingException;
import com.teamSupport.allSport.exception.EbloInvalidRequestException;
import com.teamSupport.allSport.exception.EbloUnknownException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AbstractBaseRestController{
	   @ExceptionHandler(AbstractEbloBaseException.class)
	    public ResponseMessage abstractBaseException(HttpServletRequest req, HttpServletResponse res, final AbstractEbloBaseException exception){
	        log.error("AbstractEbloBaseException : "+exception.getMessage());
	        res.setStatus(exception.getHttpStatus().value());
	        return new ResponseMessage(exception, req.getRequestURL().toString());
	    }
	    
	    @ExceptionHandler(IllegalArgumentException.class)
	    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
	    public ResponseMessage illegalArgumentException(HttpServletRequest req, final IllegalArgumentException exception){
	        log.error("IllegalArgumentException : "+exception.getMessage());
	        return new ResponseMessage(new EbloInvalidRequestException(exception.getMessage(), exception), req.getRequestURL().toString());
	    }
	    
	    @ExceptionHandler(Exception.class)
	    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Internal server error")
	    public ResponseMessage exception(HttpServletRequest req, final Exception exception){
	        log.error("Exception : "+exception.getMessage());
	        return new ResponseMessage(new EbloUnknownException(exception.getMessage(), exception), req.getRequestURL().toString());
	    }
	 
	    @ExceptionHandler(BindException.class) 
	    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
	    public ResponseMessage bindingErrors(final HttpServletRequest req, final BindException exception) {
	        log.error("BindException : "+exception.getMessage());
	       
//	        List<FormError> formErrors = bindingResultHandler.getErrors(exception.getBindingResult());
//	        StringBuilder msg = new StringBuilder();
//	        for(FormError err : formErrors) {
//	            msg.append(String.format(bindingErrorMsgFormat, err.getInputName(), err.getMessage()));
//	        }
	        return new ResponseMessage(new BindingException(exception.getMessage(), exception), req.getRequestURL().toString());
	    }
}
