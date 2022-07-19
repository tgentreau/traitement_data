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

    /**
     * Creation de l'objet Acteur
     * @param object
     */
    public void createOBJActor(Object object) {
        Personne personne = new Personne();
        Acteur acteurToCreate = new Acteur();
        Naissance naissance = new Naissance();

        Map<String, Object> mapActeur = (Map) object;

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

        checkDuplicateActor(acteurToCreate);

        List<Role> roleList = new ArrayList<>();
        List<Object> listRoles = (List<Object>) mapActeur.get("roles");

        for (Object listRole : listRoles) {
            roleList.add(roleBuilder.createOBJRole(listRole));
        }

        if(acteurToCreate.getId() == null) {
            System.out.println(acteurToCreate);
        }
        for (Role role : roleList) {
            role.setActeur(acteurToCreate);
        }


    }

    /**
     * Verification de doublons dans la bdd et persist de l'acteur
     * @param acteur
     * @return
     */
    public Acteur checkDuplicateActor(Acteur acteur) {
        if(acteurDAO.get(acteur) == null) {
            acteurDAO.create(acteur);
            return acteur;
        } else {
            Acteur acteurBD = acteurDAO.get(acteur);
            acteur.setId(acteurBD.getId());
            return acteurBD;
        }
    }
}
