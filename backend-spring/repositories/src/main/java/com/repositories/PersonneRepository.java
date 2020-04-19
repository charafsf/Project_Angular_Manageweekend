package com.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Personne;

@Repository
public interface PersonneRepository extends	JpaRepository<Personne, Long>{
	public List<Personne> findByFirstName(String nom);
	public Optional<Personne> findById(Long id);

}
