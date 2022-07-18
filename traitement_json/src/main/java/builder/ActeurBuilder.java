package builder;

import bo.*;
import dal.ActeurDAO;
import dal.NaissanceDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActeurBuilder {
    ActeurDAO acteurDAO = new ActeurDAO();
    RoleBuilder roleBuilder = new RoleBuilder();
    NaissanceDAO naissanceDAO = new NaissanceDAO();
    public ActeurBuilder() {
    }
    public void createOBJActor(Object acteur) {
        Personne personne = new Personne();
        Acteur acteurToCreate = new Acteur();
        Naissance naissance = new Naissance();

        Map<String, Object> mapActeur = (Map) acteur;

        if(mapActeur.get("identite") != null) {
            personne.setIdentite((String) mapActeur.get("identite"));
        } else {
            personne.setIdentite("null");
        }
        Map<String, Object> mapNaissance = (Map) mapActeur.get("naissance");
        naissance.setDateNaissance((String) mapNaissance.get("dateNaissance"));
        naissance.setLieuNaissance((String) mapNaissance.get("lieuNaissance"));
        acteurToCreate.setIdIMDB((String) mapActeur.get("id"));
        acteurToCreate.setNaissance(naissance);
        personne.setUrl((String) mapActeur.get("url"));
        acteurToCreate.setPersonne(personne);


        List<Role> roleList = new ArrayList<>();
        List<Object> listRoles = (List<Object>) mapActeur.get("roles");
        for (Object listRole : listRoles) {
            roleList.add(roleBuilder.createOBJRole(listRole));
        }

        for (Role role : roleList) {
            role.setActeur(acteurToCreate);
        }

        acteurDAO.create(acteurToCreate);

    }



    public Acteur checkDuplicateActor(Acteur acteur) {
        Naissance naissance = naissanceDAO.get(acteur.getNaissance());
        if(naissance != null) {
            acteur.setNaissance(naissance);
            naissance.getActeurs().add(acteur);
        }
        return acteur;
    }
}
