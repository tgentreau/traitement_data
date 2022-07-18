package dal;

import bll.MovieManager;
import bo.LieuTournage;

import javax.persistence.TypedQuery;

public class LieuTournageDAO extends AbstractDAO implements DAO<LieuTournage>{
    @Override
    public LieuTournage get(LieuTournage data) {
        TypedQuery<LieuTournage> query = em.createQuery("select e from LieuTournage e where e.pays = :pays and e.etat = :etat and e.ville = :ville", LieuTournage.class);
        query.setParameter("pays", data.getPays());
        query.setParameter("etat", data.getEtat());
        query.setParameter("ville", data.getVille());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
