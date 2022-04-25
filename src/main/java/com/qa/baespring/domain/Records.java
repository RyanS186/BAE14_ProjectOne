package com.qa.baespring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Records {

	@Id // Setting column as the Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Setting the column to auto-increment
	private long id;
	
	// Declaring private variables
	
	@Column(nullable = false)
	private String albumName;
	
	@Column(nullable = false)
	private String artistName;
	
	@Column
	private String genre;
	
	@Column
	private int releaseYear;
	
	// Constructors
	
	public Records() {}

	public Records(String albumName, String artistName, String genre, int releaseYear) {
		super();
		this.albumName = albumName;
		this.artistName = artistName;
		this.genre = genre;
		this.releaseYear = releaseYear;
	}

	public Records(long id, String albumName, String artistName, String genre, int releaseYear) {
		super();
		this.id = id;
		this.albumName = albumName;
		this.artistName = artistName;
		this.genre = genre;
		this.releaseYear = releaseYear;
	}

	
}
