package fr.istic.taa_gli.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Personne {
	
	private Long id;

    private String name;

    private String email;
    
    private Liste_lieux liste_lieux;
    
    private List<Sport> sports;
    
    private Authentification authentification;
    
    public Personne() {
	}
    
	public Personne(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@ManyToOne
	public Liste_lieux getListe_lieux() {
		return liste_lieux;
	}
	public void setListe_lieux(Liste_lieux liste_lieux) {
		this.liste_lieux = liste_lieux;
	}
	
	public void setSports (List<Sport> sports) {
		this.sports = sports;
	}
	@ManyToMany(mappedBy ="personnes", cascade =CascadeType.PERSIST)
	public List<Sport> getSports() {
		return sports;
	}
	@OneToOne
	public Authentification getAuthentification() {
		return authentification;
	}
	public void setAuthentification(Authentification authentification) {
		this.authentification = authentification;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", name=" + name + ", email=" + email + ", liste_lieux=" + liste_lieux
				+ ", sports=" + sports + ", authentification=" + authentification + "]";
	}
	
	
	
}
