package dal;

import bo.Acteur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class AbstractDAO {

    static EntityManagerFactory emf = DAOFactory.getFactory();
    static EntityManager em = emf.createEntityManager();

    public void create(Object obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }
}
