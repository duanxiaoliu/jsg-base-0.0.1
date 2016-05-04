package com.jsg.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
	
	
	@ExceptionHandler
	public String conException(HttpServletRequest request,Exception ex,ModelMap model){
		
		return "";
	}
}
