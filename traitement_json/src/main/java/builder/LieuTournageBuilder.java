package builder;

import bo.LieuTournage;
import dal.LieuTournageDAO;

import java.util.Map;

public class LieuTournageBuilder {
    LieuTournageDAO lieuTournageDAO = new LieuTournageDAO();

    /**
     * Création de l'objet LieuTournage
     * @param lieu
     * @return
     */
    public LieuTournage createOBJLieu(Object lieu) {
        LieuTournage lieuTournage = new LieuTournage();
        Map<String, Object> mapTournage = (Map) lieu;
        lieuTournage.setPays((String) mapTournage.get("pays"));
        lieuTournage.setEtat((String) mapTournage.get("etatDept"));
        lieuTournage.setVille((String) mapTournage.get("ville"));
        return checkDuplicateLieu(lieuTournage);
    }

    /**
     * Verification de doublons dans la bdd et persist du lieu de tournage
     * @param lieuTournage
     * @return
     */
    public LieuTournage checkDuplicateLieu(LieuTournage lieuTournage) {
        if(lieuTournageDAO.get(lieuTournage) == null) {
            lieuTournageDAO.create(lieuTournage);
            return lieuTournage;
        } else {
            return lieuTournageDAO.get(lieuTournage);
        }
    }
}
