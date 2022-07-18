package dal;

import bll.MovieManager;
import bo.Pays;

import javax.persistence.TypedQuery;

public class PaysDAO extends AbstractDAO implements DAO<Pays>{
    @Override
    public Pays get(Pays data) {
        TypedQuery<Pays> query = em.createQuery("select e from Pays e where e.nom = :nom and e.url = :url", Pays.class);
        query.setParameter("nom", data.getNom());
        query.setParameter("url", data.getUrl());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
