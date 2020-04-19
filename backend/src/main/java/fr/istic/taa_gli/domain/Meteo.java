package fr.istic.taa_gli.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Meteo {

	
	private Long id ;
	
    private boolean soleil;
    
	private boolean pluie;
	
	private boolean vent;
	
	private List<Sport> sports;

	public Meteo() {
	}
	
	public Meteo(boolean soleil, boolean pluie, boolean vent) {
		super();
		this.soleil = soleil;
		this.pluie = pluie;
		this.vent = vent;
	}

    @Id
    @GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isSoleil() {
		return soleil;
	}

	public void setSoleil(boolean soleil) {
		this.soleil = soleil;
	}

	public boolean isPluie() {
		return pluie;
	}

	public void setPluie(boolean pluie) {
		this.pluie = pluie;
	}

	public boolean isVent() {
		return vent;
	}

	public void setVent(boolean vent) {
		this.vent = vent;
	}
	@ManyToMany (mappedBy ="meteo", cascade = CascadeType.PERSIST)
	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}
	
}
