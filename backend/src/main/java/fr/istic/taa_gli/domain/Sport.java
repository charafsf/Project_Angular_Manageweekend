package fr.istic.taa_gli.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Sport {

	private Long id;

    private String name;
    
    private List<Personne> personnes;
    
    private List<Meteo> meteo;
    
    private List<Liste_lieux> liste_lieux;
    
    public Sport() {
	}
    
	public Sport(String name) {
		super();
		this.name = name;
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
	@ManyToMany
	public List<Personne> getPersonnes() {
		return personnes;
	}
	
	public void setPersonnes(List<Personne> personnes) {
		this.personnes= personnes;
	}
	@ManyToMany
	public List<Meteo> getMeteo() {
		return meteo;
	}
	public void setMeteo(List<Meteo> meteo) {
		this.meteo = meteo;
	}
	@OneToMany(mappedBy ="sport" , cascade = CascadeType.PERSIST )
	public List<Liste_lieux> getListe_lieux() {
		return liste_lieux;
	}
	public void setListe_lieux(List<Liste_lieux> liste_lieux) {
		this.liste_lieux = liste_lieux;
	}
	 

}
