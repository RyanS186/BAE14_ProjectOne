package com.qa.baespring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping("/getById/{id}") // localhost:8080/records/getById
	public ResponseEntity<Records> getById(@PathVariable long id) {
		return new ResponseEntity<Records>(service.getById(id), HttpStatus.OK);
	}
	
	// Get by Artist
	@GetMapping("/getByArtist/{artistName}") // localhost:8080/records/getByArtist/
	public ResponseEntity<List<Records>> getByArtistName(@PathVariable String artistName) {
		return new ResponseEntity<List<Records>>(service.getByArtistName(artistName), HttpStatus.OK);
	}
	
	// Get by year
	@GetMapping("/getByYear/{releaseYear}") // localhost:8080/records/getByYear
	public ResponseEntity<List<Records>> getByReleaseYear(@PathVariable int releaseYear) {
		return new ResponseEntity<List<Records>>(service.getByReleaseYear(releaseYear), HttpStatus.OK);
	}
	
	// Get by genre
	@GetMapping("/getByGenre/{genre}") // localhost:8080/records/getByGenre
	public ResponseEntity<List<Records>> getByGenre(@PathVariable String genre) {
		return new ResponseEntity<List<Records>>(service.getByGenre(genre), HttpStatus.OK);
	}
	
	// POST
	@PostMapping("/create") // localhost:8080/records/create
	public ResponseEntity<Records> create(@RequestBody Records record) {
		return new ResponseEntity<Records>(service.create(record), HttpStatus.CREATED);
	}
	
	// PUT
	@PutMapping("/update/{id}") //localhost:8080/records/create/update/id
	public ResponseEntity<Records> update(@PathVariable long id, @RequestBody Records record) {
		return new ResponseEntity<Records>(service.update(id, record), HttpStatus.OK);
	}
	
	// DELETE
	@DeleteMapping("/delete/{id}") //localhost:8080/records/delete/id
	public ResponseEntity<?> delete(@PathVariable long id) {
		return (service.delete(id)) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
