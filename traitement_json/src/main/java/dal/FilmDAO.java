package dal;

import bll.MovieManager;
import bo.Film;
import bo.Pays;

import javax.persistence.TypedQuery;

public class FilmDAO implements DAO<Film>{
    MovieManager service = MovieManager.getInstance();
    @Override
    public Film get(Film data) {
        TypedQuery<Film> query = service.getConnection().createQuery("select e from Film where e.nom = :nom", Film.class);
        query.setParameter("nom", data.getNom());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
