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
	
	// Get by artist
	public List<Records> getByArtistName(String artistName) {
		return repo.findByArtistName(artistName);
	}
	
	// Get by year
	public List<Records> getByReleaseYear(int releaseYear) {
		return repo.findByReleaseYear(releaseYear);
	}
	
	// Create a new record
	public Records create(Records record) {
		return repo.saveAndFlush(record);
	}
	
	// Update a record
	public Records update(long id, Records record) {
		Records existing = repo.findById(id).get(); // Get the existing record
		existing.setAlbumName(record.getAlbumName()); // Change existing album name to new album name
		existing.setArtistName(record.getArtistName()); // Change existing artist name to new artist name
		existing.setGenre(record.getGenre()); // Change existing genre to new genre
		existing.setReleaseYear(record.getReleaseYear()); // Change existing release year to new release year
		return repo.saveAndFlush(existing);
	}
	
	// Delete a record
	public boolean delete(long id) {
		repo.deleteById(id);
		return !repo.existsById(id); // Due to the !, this method will return true if the delete is successful
	}
}
