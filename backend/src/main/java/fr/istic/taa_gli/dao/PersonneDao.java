package fr.istic.taa_gli.dao;

import java.util.List;

import fr.istic.taa_gli.domain.Authentification;
import fr.istic.taa_gli.domain.Liste_lieux;
import fr.istic.taa_gli.domain.Personne;
import fr.istic.taa_gli.domain.Sport;

public class PersonneDao {
	
	public Personne findById(Long id) {
		return EntityManagerHelper.getEntityManager().find(Personne.class, id);
	}
	
	public Personne save(Personne p) {
        EntityManagerHelper.beginTransaction();
        
        Long id=p.getId();
        if (id !=null) {
            EntityManagerHelper.getEntityManager().merge(p);

        } else {
            EntityManagerHelper.getEntityManager().persist(p);

        }
        EntityManagerHelper.commit();
        return p;

    }
	
	public Personne save(Personne p, Authentification log) {
        EntityManagerHelper.beginTransaction();
        
        Long id=p.getId();
        if (id !=null) {
            EntityManagerHelper.getEntityManager().merge(p);

        } else {
        	p.setAuthentification(log);
            EntityManagerHelper.getEntityManager().persist(p);

        }
        EntityManagerHelper.commit();
        return p;
    }
	
	public Personne save(Personne p, Liste_lieux adresse) {
        EntityManagerHelper.beginTransaction();
        
        Long id=p.getId();
        if (id !=null) {
            EntityManagerHelper.getEntityManager().merge(p);

        } else {
        	p.setListe_lieux(adresse);
            EntityManagerHelper.getEntityManager().persist(p);

        }
        EntityManagerHelper.commit();
        return p;
    }
	
	public void delete(long id) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findById(id));
        EntityManagerHelper.commit();        
    }
	
	public List<Personne> findAll() {
		String s = "select p from Personne as p";

        return EntityManagerHelper.getEntityManager().createQuery(s,Personne.class)
                .getResultList();
	}
	
	public List<Personne> getAll4Persons(Sport s) {
        
        String str = "select distinct s.personnes from Sport as s "
                + "where s.name = :sport";

        return EntityManagerHelper.getEntityManager().createQuery(str).setParameter("sport", s)
                .getResultList();

        
	}
}
