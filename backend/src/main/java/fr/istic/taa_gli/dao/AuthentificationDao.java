
package fr.istic.taa_gli.dao;

import java.util.List;
import fr.istic.taa_gli.domain.Authentification;

public class AuthentificationDao {
	public Authentification findByName(String login) {
		return EntityManagerHelper.getEntityManager().find(Authentification.class, login);
	}

	public Authentification save(Authentification au) {
		EntityManagerHelper.beginTransaction();
		if (!au.getLogin().isEmpty()) {
			EntityManagerHelper.getEntityManager().merge(au);
		} else {
			EntityManagerHelper.getEntityManager().persist(au);
		}
		EntityManagerHelper.commit();
		return au;
	}

	public void delete(String log) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(this.findByName(log));
		EntityManagerHelper.commit();
	}

	public List<Authentification> findAll() {
		String s = "select log from Authentification as log";
		return EntityManagerHelper.getEntityManager().createQuery(s, Authentification.class).getResultList();
	}
}
