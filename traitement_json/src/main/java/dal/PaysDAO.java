package dal;

import bll.MovieManager;
import bo.Pays;

import javax.persistence.TypedQuery;

public class PaysDAO implements DAO<Pays>{
    MovieManager service = MovieManager.getInstance();
    @Override
    public Pays get(Pays data) {
        TypedQuery<Pays> query = service.getConnection().createQuery("select e from Pays where e.nom = :nom and e.url = :url", Pays.class);
        query.setParameter("nom", data.getNom());
        query.setParameter("url", data.getUrl());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
