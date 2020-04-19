package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Sport implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
    private String name;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy ="sports")
    private List<Personne> personnes;
    
    @OneToMany(mappedBy = "sport")
    private List<Location> locations;
    
    @ManyToMany
    private List<Weather> weathers;
}
