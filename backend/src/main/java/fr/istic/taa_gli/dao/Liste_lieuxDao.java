
package fr.istic.taa_gli.dao;

import java.util.List;
import fr.istic.taa_gli.domain.Liste_lieux;

public class Liste_lieuxDao {
	public Liste_lieux findById(Long id) {
		return EntityManagerHelper.getEntityManager().find(Liste_lieux.class, id);
	}

	public Liste_lieux save(Liste_lieux lieu) {
		EntityManagerHelper.beginTransaction();
		if (lieu.getId() != 0) {
			EntityManagerHelper.getEntityManager().merge(lieu);
		} else {
			EntityManagerHelper.getEntityManager().persist(lieu);
		}
		EntityManagerHelper.commit();
		return lieu;
	}

	public void delete(long id) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(this.findById(id));
		EntityManagerHelper.commit();
	}

	public List<Liste_lieux> findAll() {
		String s = "select lieu from Liste_lieux as lieu";
		return EntityManagerHelper.getEntityManager().createQuery(s, Liste_lieux.class).getResultList();
	}
}
