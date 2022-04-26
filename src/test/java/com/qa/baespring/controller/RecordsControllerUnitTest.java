package com.qa.baespring.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.baespring.domain.Records;
import com.qa.baespring.service.RecordsService;

@WebMvcTest
public class RecordsControllerUnitTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private RecordsService service;
	
	// Get ALL test
	@Test
	public void getAllTest() throws Exception {
		Records record = new Records(1L, "The Lost Boy", "Cordae", "Hip Hop", 2019);
		List<Records> output = new ArrayList<>();
		output.add(record);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		Mockito.when(service.getAll()).thenReturn(output);
		
		mvc.perform(get("/records/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
	}
	
	// Get by ID test
	@Test
	public void getByIdTest() throws Exception {
		Records record = new Records(1L, "The Lost Boy", "Cordae", "Hip Hop", 2019);
		String recordAsJSON = mapper.writeValueAsString(record);
		
		Mockito.when(service.getByID(1)).thenReturn(record);
		
		mvc.perform(get("/records/getById/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(recordAsJSON));
	}
	
	// Get by Artist test
	@Test
	public void getByArtistTest() throws Exception {
		Records record = new Records(1L, "The Lost Boy", "Cordae", "Hip Hop", 2019);
		List<Records> output = new ArrayList<>();
		output.add(record);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		Mockito.when(service.getByArtistName("Cordae")).thenReturn(output);
		
		mvc.perform(get("/records/getByArtist/Cordae")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
	}
	
	// Get by Year test
	@Test
	public void getByYearTest() throws Exception {
		Records record = new Records(1L, "The Lost Boy", "Cordae", "Hip Hop", 2019);
		List<Records> output = new ArrayList<>();
		output.add(record);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		Mockito.when(service.getByReleaseYear(2019)).thenReturn(output);
		
		mvc.perform(get("/records/getByYear/2019")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
	}
	
	// Get by Genre test
	@Test
	public void getByGenreTest() throws Exception {
		Records record = new Records(1L, "The Lost Boy", "Cordae", "Hip Hop", 2019);
		List<Records> output = new ArrayList<>();
		output.add(record);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		Mockito.when(service.getByGenre("Hip Hop")).thenReturn(output);
		
		mvc.perform(get("/records/getByGenre/Hip Hop")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
	}
	
	// Create test
	@Test
	public void createTest() throws Exception {
		Records entry = new Records("Born to Run", "Bruce Springsteen", "Rock & Roll", 1975);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Records result = new Records(2L, "Born to Run", "Bruce Springsteen", "Rock & Roll", 1975);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.create(entry)).thenReturn(result);
		
		mvc.perform(post("/records/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(resultAsJSON));
	}
	
	// Update test
	@Test
	public void updateTest() throws Exception {
		Records entry = new Records("From a Birds Eye View", "Cordae", "Hip Hop", 2022);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Records result = new Records(1L, "From a Birds Eye View", "Cordae", "Hip Hop", 2022);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.update(1, entry)).thenReturn(result);
		
		mvc.perform(put("/records/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isOk())
				.andExpect(content().json(resultAsJSON));
	}
	
	// Delete test
	@Test
	public void deleteTest() throws Exception {
		
		Mockito.when(service.delete(1)).thenReturn(true);
		
		mvc.perform(delete("/records/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
}

