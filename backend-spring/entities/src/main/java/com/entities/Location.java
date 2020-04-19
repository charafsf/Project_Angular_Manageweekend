package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
	@Id @GeneratedValue
	private Long id;
    private String name;
    private AdressType type;
    private int id_parent;
    
    @ManyToOne
    private Sport sport;
    
    @OneToMany(mappedBy = "location")
    private List<Personne> personnes;

}
