package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Authentification;


@Repository
public interface AuthentificationRepository extends JpaRepository<Authentification, String>{
	public Authentification findByLogin(String login);

}
