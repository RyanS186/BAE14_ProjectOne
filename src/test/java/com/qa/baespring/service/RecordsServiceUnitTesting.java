package com.qa.baespring.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.baespring.domain.Records;
import com.qa.baespring.repo.RecordsRepo;

@SpringBootTest
@ActiveProfiles("test")
public class RecordsServiceUnitTesting {

	// Injects the service
	@Autowired
	private RecordsService service;
	
	// Mocks the repo
	@MockBean
	private RecordsRepo repo;
	
	@Test
	void getAllTest() {
		List<Records> testRecords = List.of(new Records(1L, "Born to Run", "Bruce Springsteen", "Rock & Roll", 1975));
		
		Mockito.when(this.repo.findAll()).thenReturn(testRecords);
		assertThat(this.service.getAll()).isEqualTo(testRecords);
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	

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
	
	@Test
	void updateTest() {
		long id = 1L;
		Records existingRecord = new Records(1L, "Born in the U.S.A", "Bruce Springsteen", "Rock & Roll", 1984);
		Records updatedRecord = new Records(1L, "Nebraska", "Bruce Springsteen", "Folk", 1982);
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existingRecord));
		Mockito.when(this.repo.saveAndFlush(updatedRecord)).thenReturn(updatedRecord);
		
		assertThat(this.service.update(id, new Records("Nebraska", "Bruce Springsteen", "Folk", 1982))).isEqualTo(updatedRecord);
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(updatedRecord);
	}

	@Test
	void deleteTest() {
		long id = 1;
		
		Mockito.when(this.repo.existsById(id)).thenReturn(false);
		assertThat(this.service.delete(id)).isEqualTo(true);
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}
}