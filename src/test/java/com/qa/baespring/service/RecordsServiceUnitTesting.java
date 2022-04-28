package com.qa.baespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.baespring.repo.RecordsRepo;

@SpringBootTest
public class RecordsServiceUnitTesting {

	@Autowired
	private RecordsService service;
	
	@MockBean
	private RecordsRepo repo;
	
}
