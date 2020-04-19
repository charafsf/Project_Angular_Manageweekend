package fr.istic.taa_gli.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.taa_gli.dao.AuthentificationDao;
import fr.istic.taa_gli.dao.PersonneDao;;

public class Test {
	private EntityManager manager;

    public Test(EntityManager manager) {
        this.manager = manager;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory =   
              Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        Test test = new Test(manager);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
        	
        	AuthentificationDao auth = new AuthentificationDao();
        	PersonneDao personne = new PersonneDao();
        	Personne p= new Personne("barry", "barry@gmail.com");
        	
        	Authentification aut = new Authentification("test1", "123456");
        	System.out.println(auth.save(aut));
        	p.setAuthentification(aut);
        	System.out.println("here : "+auth.findByName("test"));
        	System.out.println(personne.save(p)); 
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
           
    }

}
