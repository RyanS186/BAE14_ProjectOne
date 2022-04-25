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
	
	// Default constructor
	public Records() {}

	// Constructor ommiting id for creating/inserting
	public Records(String albumName, String artistName, String genre, int releaseYear) {
		super();
		this.albumName = albumName;
		this.artistName = artistName;
		this.genre = genre;
		this.releaseYear = releaseYear;
	}
	
	// Constructor including id for reading/selecting (and testing)
	public Records(long id, String albumName, String artistName, String genre, int releaseYear) {
		super();
		this.id = id;
		this.albumName = albumName;
		this.artistName = artistName;
		this.genre = genre;
		this.releaseYear = releaseYear;
	}

	// Public get and set methods to access and update the value of private variables
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}


	
}
