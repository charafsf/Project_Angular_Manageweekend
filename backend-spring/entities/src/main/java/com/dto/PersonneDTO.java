package com.dto;

import java.util.List;

import com.entities.Authentification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonneDTO {
	

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Authentification authentification;
	private LocationDTO locationDTO;

	private List<String> sportsName;
}
