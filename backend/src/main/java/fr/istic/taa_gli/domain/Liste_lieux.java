package fr.istic.taa_gli.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Liste_lieux {
	
	private Long id;

    private String nom;
    
    private String type;
     
    private int id_parent;
    
    private List<Personne> personnes;
    
    private Sport sport;

    public Liste_lieux() {
	}
    
	public Liste_lieux(String nom, String type, int id_parent) {
		super();
		this.nom = nom;
		this.type = type;
		this.id_parent = id_parent;
	}

    @Id
    @GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId_parent() {
		return id_parent;
	}

	public void setId_parent(int id_parent) {
		this.id_parent = id_parent;
	}
	@OneToMany(mappedBy = "liste_lieux", cascade = CascadeType.PERSIST)
	public List<Personne> getPersonnes(){
		return personnes;
	}
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}
	@ManyToOne
	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

}
