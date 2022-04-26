package com.qa.baespring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.baespring.domain.Records;
import com.qa.baespring.service.RecordsService;

@RestController
@CrossOrigin
@RequestMapping("/records")
public class RecordsController {

	// Link to service
	private RecordsService service;
	
	public RecordsController (RecordsService service) {
		this.service = service;
	}
	
	// GET
	
	// GetAll (Get all Records)
	@GetMapping("/getAll") // localhost:8080/records/getAll
	public ResponseEntity<List<Records>> getAll() {
		return new ResponseEntity<List<Records>>(service.getAll(), HttpStatus.OK);
	}
	
	// Get by ID (Get one Record)
	@GetMapping("/getById/{id}")
	public ResponseEntity<Records> getById(@PathVariable long id) {
		return new ResponseEntity<Records>(service.getByID(id), HttpStatus.OK);
	}
}
