package com.context;



import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "PersonneContext")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen")
@JsonIgnoreProperties({ "PersonneContext" })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonneContext  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idPersonne;
	private String firstName;
	private String lastName;
    private String email;
    
	private String idLocation;
	private String login;
	private List<String> sportsName;

}
