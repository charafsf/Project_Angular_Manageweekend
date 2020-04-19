package com.trash;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDATA {

	private String login;
	private String password;
	private String lastName;
	private String firstName;
	private String email;
	private String sport;
	private String adress;
	private String weather;
}
