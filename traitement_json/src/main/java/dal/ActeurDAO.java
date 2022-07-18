package dal;

import bll.MovieManager;
import bo.Acteur;

import javax.persistence.TypedQuery;

public class ActeurDAO extends AbstractDAO implements DAO<Acteur>{
    @Override
    public Acteur get(Acteur data) {
        TypedQuery<Acteur> query = em.createQuery("select e from Acteur e where e.personne.identite = :identite", Acteur.class);
        query.setParameter("identite", data.getPersonne().getIdentite());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public void create(Acteur acteur) {
        em.getTransaction().begin();
        em.persist(acteur);
        em.getTransaction().commit();
    }
}
