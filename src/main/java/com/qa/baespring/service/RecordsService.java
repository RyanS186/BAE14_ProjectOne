package com.qa.baespring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.baespring.domain.Records;
import com.qa.baespring.repo.RecordsRepo;

@Service
public class RecordsService {

	// Link to repo
	private RecordsRepo repo;
	
	public RecordsService(RecordsRepo repo) {
		this.repo = repo;
	}
	
	// Get ALL records
	public List<Records> getAll() {
		return repo.findAll();
	}
	
	// Get by Id
	public Records getByID(long id) {
		return repo.findById(id).get();
	}
	
	// Create a new record
	public Records create(Records record) {
		return repo.saveAndFlush(record);
	}
	
	// Update a record
	public Records update(long id, Records record) {
		Records existing = repo.findById(id).get();
		existing.setAlbumName(record.getAlbumName());
		existing.setArtistName(record.getArtistName());
		existing.setGenre(record.getGenre());
		existing.setReleaseYear(record.getReleaseYear());
		return repo.saveAndFlush(existing);
	}
	
	
}
