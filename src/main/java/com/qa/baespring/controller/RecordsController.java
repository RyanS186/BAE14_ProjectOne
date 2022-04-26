package com.qa.baespring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.baespring.service.RecordsService;

@RestController
@CrossOrigin
@RequestMapping("/Records")
public class RecordsController {

	// Link to service
	private RecordsService service;
	
	public RecordsController (RecordsService service) {
		this.service = service;
	}
	
	
}
