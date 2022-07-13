package dal;

import bll.MovieManager;
import bo.Realisateur;

import javax.persistence.TypedQuery;

public class RealisateurDAO implements DAO<Realisateur>{
    MovieManager service = MovieManager.getInstance();
    @Override
    public Realisateur get(Realisateur data) {
        TypedQuery<Realisateur> query = service.getConnection().createQuery("select e from Realisateur where e.identite = :identite", Realisateur.class);
        query.setParameter("identite", data.getIdentite());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
