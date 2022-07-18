package dal;

import bll.MovieManager;
import bo.Film;
import bo.Naissance;

import javax.persistence.TypedQuery;

public class NaissanceDAO extends AbstractDAO implements DAO<Naissance>{
    @Override
    public Naissance get(Naissance data) {
        TypedQuery<Naissance> query = em.createQuery("select e from Naissance e where e.dateNaissance = :dateNaissance and e.lieuNaissance = :lieuNaissance", Naissance.class);
        query.setParameter("dateNaissance", data.getDateNaissance());
        query.setParameter("lieuNaissance", data.getLieuNaissance());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
