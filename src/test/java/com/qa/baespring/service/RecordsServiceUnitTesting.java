package com.qa.baespring.service;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.baespring.domain.Records;
import com.qa.baespring.repo.RecordsRepo;

@SpringBootTest
public class RecordsServiceUnitTesting {

	@Autowired
	private RecordsService service;
	
	@MockBean
	private RecordsRepo repo;
	
	@Test
	void createTest() {
		Records newRecord = new Records("Born to Run", "Bruce Springsteen", "Rock & Roll", 1975);
		Records savedRecord = new Records(1L, "Born to Run", "Bruce Springsteen", "Rock & Roll", 1975);
		
		// Testing functionality
		// skips over the saveAndFlush method to return a set value
		Mockito.when(this.repo.saveAndFlush(newRecord)).thenReturn(savedRecord); 
		assertThat(this.service.create(newRecord)).isEqualTo(savedRecord);
		
		// Testing method structure
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(newRecord);
	}
	

}
