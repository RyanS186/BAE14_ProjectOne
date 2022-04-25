package com.qa.baespring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.baespring.domain.Records;

public interface RecordsRepo extends JpaRepository<Records, Long> {

}
