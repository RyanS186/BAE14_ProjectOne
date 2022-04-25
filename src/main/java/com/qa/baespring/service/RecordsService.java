package com.qa.baespring.service;

import org.springframework.stereotype.Service;

import com.qa.baespring.repo.RecordsRepo;

@Service
public class RecordsService {

	//Link to repo
	private RecordsRepo repo;
	
	public RecordsService(RecordsRepo repo) {
		this.repo = repo;
	}
	
	
}
