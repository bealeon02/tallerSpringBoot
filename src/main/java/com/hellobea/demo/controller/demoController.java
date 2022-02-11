package com.hellobea.demo.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.hellobea.demo.model.Test;
import com.hellobea.demo.services.demoService;

import io.swagger.annotations.Api;

@Api(value = "api")
@RestController
@Validated
public class demoController {

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
		return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		
	}
	
	
	 @Autowired
	 private demoService service;
	 
	 @RequestMapping(method = RequestMethod.GET, value= "/hello")
	 @ResponseBody
	 public String muestraString() {
		  
	    return service.muestraString();
	 }


	 
	 
	 @RequestMapping(method = RequestMethod.GET, value= "/users")
	 @ResponseBody
	
	 
	 public List<Test> getUsers() {
		  
	    return service.consultarTabla();

	 
	 }
	 
	 
	 @RequestMapping(method = RequestMethod.DELETE, value= "/users/{id}")
	 @ResponseBody

	 public Test deleteUsers(@PathVariable int id) {
		  
	    return service.borrarCampo(id);
	    
	 }
	 
	 @RequestMapping(method = RequestMethod.POST, value= "/users")
	 @ResponseBody
	 public Test addUsers(@RequestBody Test ut) {
		  
	    return service.agregarCampo(ut);


	 }
	 
	 @RequestMapping(method = RequestMethod.POST, value= "/update")
	 @ResponseBody
	 public Test updateUser(@RequestBody Test ut) {
		  
	    return service.updateCampo(ut);
	 }
}
