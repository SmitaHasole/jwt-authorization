package com.medgenome.clientportal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medgenome.clientportal.model.ErrorInformation;

@ControllerAdvice
@RestController
public class ExceptionControllerAdvice {
  private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

  @ResponseBody
  @ExceptionHandler(Exception.class)
  public ErrorInformation exception(Exception exception, HttpServletResponse response,
      HttpServletRequest request) {
	  if(exception instanceof AuthenticationException){
		  response.setStatus(401);
		    logger.error("An exception occurred while operation : ", exception);
		    return new ErrorInformation("401", "Authentication Failed. Username or Password not valid.");  
	  }
	  response.setStatus(500);
	  return new ErrorInformation("500", "Something went wrong! Please contact admin!!");
    
  }
}
