package dal;

import bll.MovieManager;
import bo.Acteur;

import javax.persistence.TypedQuery;

public class ActeurDAO implements DAO<Acteur>{
    MovieManager service = MovieManager.getInstance();
    @Override
    public Acteur get(Acteur data) {
        TypedQuery<Acteur> query = service.getConnection().createQuery("select e from Acteur where e.identite = :identite", Acteur.class);
        query.setParameter("identite", data.getIdentite());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
