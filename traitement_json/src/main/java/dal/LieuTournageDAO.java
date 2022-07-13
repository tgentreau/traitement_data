package dal;

import bll.MovieManager;
import bo.LieuTournage;

import javax.persistence.TypedQuery;

public class LieuTournageDAO implements DAO<LieuTournage>{
    MovieManager service = MovieManager.getInstance();
    @Override
    public LieuTournage get(LieuTournage data) {
        TypedQuery<LieuTournage> query = service.getConnection().createQuery("select e from LieuTournage where e.pays = :pays and e.etat = :etat and e.ville = :ville", LieuTournage.class);
        query.setParameter("pays", data.getPays());
        query.setParameter("etat", data.getEtat());
        query.setParameter("ville", data.getVille());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
