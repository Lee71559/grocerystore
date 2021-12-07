package com.example.springcustomers;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springcustomers.Process;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public interface ProcessRepository extends JpaRepository <Process, Integer> {

	Process findById(Long id);

	@Modifying
	@Query("update Process c set c.orderid = ?1 where c.id = ?2")
	void updateProcess( Long orderid, Long id);

	void deleteById(Long id);
}