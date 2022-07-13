package dal;

import bll.MovieManager;
import bo.Genre;

import javax.persistence.TypedQuery;

public class GenreDAO implements DAO<Genre>{

    MovieManager service = MovieManager.getInstance();
    @Override
    public Genre get(Genre data) {
        TypedQuery<Genre> query = service.getConnection().createQuery("select e from Genre where e.nom = :nom", Genre.class);
        query.setParameter("nom", data.getNom());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
