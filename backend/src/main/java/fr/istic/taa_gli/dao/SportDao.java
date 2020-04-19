
package fr.istic.taa_gli.dao;

import java.util.List;
import fr.istic.taa_gli.domain.Personne;
import fr.istic.taa_gli.domain.Sport;

public class SportDao {
	public Sport findById(Long id) {
		return EntityManagerHelper.getEntityManager().find(Sport.class, id);
	}

	public Sport save(Sport s) {
		EntityManagerHelper.beginTransaction();
		if (s.getId() != 0) {
			EntityManagerHelper.getEntityManager().merge(s);
		} else {
			EntityManagerHelper.getEntityManager().persist(s);
		}
		EntityManagerHelper.commit();
		return s;
	}

	public void delete(long id) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(this.findById(id));
		EntityManagerHelper.commit();
	}

	public List<Sport> findAll() {
		String s = "select s from Sport as s";
		return EntityManagerHelper.getEntityManager().createQuery(s, Sport.class).getResultList();
	}

	public List<Sport> getAll4Sports(Personne p) {
		String str = "select distinct p.sports from Personne as p " + "where p.name = :personne";
		return EntityManagerHelper.getEntityManager().createQuery(str).setParameter("personne", p).getResultList();
	}
}
