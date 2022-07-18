package dal;

import bll.MovieManager;
import bo.Realisateur;

import javax.persistence.TypedQuery;

public class RealisateurDAO extends AbstractDAO implements DAO<Realisateur>{
    @Override
    public Realisateur get(Realisateur data) {
        TypedQuery<Realisateur> query = em.createQuery("select e from Realisateur e where e.personne.identite = :identite", Realisateur.class);
        query.setParameter("identite", data.getPersonne().getIdentite());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
