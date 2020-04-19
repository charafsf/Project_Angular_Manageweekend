
package fr.istic.taa_gli.dao;

import java.util.List;
import fr.istic.taa_gli.domain.Meteo;

public class MeteoDao {
	public Meteo findById(Long id) {
		return EntityManagerHelper.getEntityManager().find(Meteo.class, id);
	}

	public Meteo save(Meteo m) {
		EntityManagerHelper.beginTransaction();
		if (m.getId() != 0) {
			EntityManagerHelper.getEntityManager().merge(m);
		} else {
			EntityManagerHelper.getEntityManager().persist(m);
		}
		EntityManagerHelper.commit();
		return m;
	}

	public void delete(long id) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(this.findById(id));
		EntityManagerHelper.commit();
	}

	public List<Meteo> findAll() {
		String s = "select m from Meteo as m";
		return EntityManagerHelper.getEntityManager().createQuery(s, Meteo.class).getResultList();
	}
}
