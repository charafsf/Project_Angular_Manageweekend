package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long>{
	public Sport findByName(String name);
	
	public void deleteByName(String name);
}
