package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Location;

@Repository
public interface LocationRepository extends	JpaRepository<Location, Long>{
	public List<Location> findByName(String nom);

}
