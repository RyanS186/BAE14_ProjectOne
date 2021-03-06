package com.qa.baespring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.baespring.domain.Records;

public interface RecordsRepo extends JpaRepository<Records, Long> {

	List<Records> findByArtistName(String artistName);
	List<Records> findByReleaseYear(int releaseYear);
	List<Records> findByGenre(String genre);
}
