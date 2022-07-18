package dal;

import bll.MovieManager;
import bo.Film;
import bo.Pays;

import javax.persistence.TypedQuery;

public class FilmDAO extends AbstractDAO implements DAO<Film>{
    @Override
    public Film get(Film data) {
        TypedQuery<Film> query = em.createQuery("select e from Film e where e.media.nom = :nom", Film.class);
        query.setParameter("nom", data.getMedia().getNom());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
