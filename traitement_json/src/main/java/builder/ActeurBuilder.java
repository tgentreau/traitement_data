package builder;

import bo.Acteur;
import bo.Film;
import bo.Naissance;
import dal.FilmDAO;
import dal.NaissanceDAO;

public class ActeurBuilder {
    NaissanceDAO naissanceDAO = new NaissanceDAO();
    public Acteur createObjActeur(Acteur acteur) {
        Naissance naissance = naissanceDAO.get(acteur.getNaissance());
        if(naissance != null) {
            acteur.setNaissance(naissance);
            naissance.getActeurs().add(acteur);
        }
        return acteur;
    }
}
