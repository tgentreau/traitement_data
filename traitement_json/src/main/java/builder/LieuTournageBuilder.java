package builder;

import bo.LieuTournage;
import dal.LieuTournageDAO;

import java.util.Map;

public class LieuTournageBuilder {
    LieuTournageDAO lieuTournageDAO = new LieuTournageDAO();

    public LieuTournage createOBJLieu(Object lieu) {
        LieuTournage lieuTournage = new LieuTournage();
        Map<String, Object> mapTournage = (Map) lieu;
        lieuTournage.setPays((String) mapTournage.get("pays"));
        lieuTournage.setEtat((String) mapTournage.get("etatDept"));
        lieuTournage.setVille((String) mapTournage.get("ville"));
        return checkDuplicateLieu(lieuTournage);
    }

    public LieuTournage checkDuplicateLieu(LieuTournage lieuTournage) {
        if(lieuTournageDAO.get(lieuTournage) == null) {
            lieuTournageDAO.create(lieuTournage);
            return lieuTournage;
        } else {
            return lieuTournageDAO.get(lieuTournage);
        }
    }
}
