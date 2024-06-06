package com.oderzy._config_;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class StartupClasses {

	
	  @PostConstruct
	  public void init(){
	    // Setting Spring Boot SetTimeZone
	    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	  }
}
