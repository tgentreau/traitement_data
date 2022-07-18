package builder;

import bo.Naissance;
import bo.Personne;
import bo.Realisateur;
import dal.RealisateurDAO;

import java.util.Map;

public class RealisateurBuilder {
    RealisateurDAO realisateurDAO = new RealisateurDAO();
    public Realisateur createOBJReal(Object real) {
        Personne personne = new Personne();
        Realisateur realToCreate = new Realisateur();
        Map<String, Object> mapReal = (Map) real;
        if(mapReal.get("identite") != null) {
            personne.setIdentite((String) mapReal.get("identite"));
        } else {
            personne.setIdentite("null");
        }
        personne.setUrl((String) mapReal.get("url"));
        realToCreate.setPersonne(personne);
        return checkDuplicateReal(realToCreate);
    }

    public Realisateur checkDuplicateReal(Realisateur realisateur) {
        if(realisateurDAO.get(realisateur) == null) {
            realisateurDAO.create(realisateur);
            return realisateur;
        } else {
            return realisateurDAO.get(realisateur);
        }
    }
}
