package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entities.ApiError;
import com.entities.Authentification;
import com.entities.EMessages;
import com.repositories.AuthentificationRepository;

@Service
public class AuthentificationService {
	
	@Autowired
	private AuthentificationRepository authRepository;
	

	public ResponseEntity<Object> getAuths() {
		return new ResponseEntity<Object>(authRepository.findAll(),HttpStatus.OK);
	}

	public ResponseEntity<Object> getLogin(String login) {
		return new ResponseEntity<Object>(this.authRepository.findById(login),HttpStatus.OK);
	}

	public ResponseEntity<Object> addLogin(Authentification auth) {
		if (false) {
			return new ResponseEntity<Object>(new ApiError(HttpStatus.BAD_REQUEST, EMessages.LOGIN_EXIST.getName()),
                    HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Object>(this.authRepository.save(auth),HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> deleteLogin(String login) {
		this.authRepository.deleteById(login);
		return this.getAuths();
	}
	
	public Authentification findAuthentificationByLogin(String login) {
        return this.authRepository.findByLogin(login);
    }
	
}
