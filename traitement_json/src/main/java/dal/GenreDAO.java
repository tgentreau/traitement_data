package dal;

import bll.MovieManager;
import bo.Genre;

import javax.persistence.TypedQuery;

public class GenreDAO extends AbstractDAO implements DAO<Genre>{
    @Override
    public Genre get(Genre data) {
        TypedQuery<Genre> query = em.createQuery("select e from Genre e where e.nom = :nom", Genre.class);
        query.setParameter("nom", data.getNom());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
