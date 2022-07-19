package builder;

import bo.Role;
import dal.RoleDAO;

import java.util.Map;

public class RoleBuilder {
    /*ActeurDAO acteurDAO = new ActeurDAO();
    FilmDAO filmDAO = new FilmDAO();*/

    RoleDAO roleDAO = new RoleDAO();
    FilmBuilder filmBuilder = new FilmBuilder();

    public RoleBuilder() {
    }

    /**
     * Création de l'objet role
     * @param role
     * @return
     */
    public Role createOBJRole(Object role) {
        Role roleToCreate = new Role();

        Map<String, Object> mapRole = (Map) role;

        roleToCreate.setCharacterName((String) mapRole.get("characterName"));

        roleToCreate.setFilm(filmBuilder.createOBJFilm(mapRole.get("film")));

        return checkDuplicateRole(roleToCreate);
    }

    /**
     * Verification de doublons dans la bdd et persist du roleVerif
     * @param roleVerif
     * @return
     */
    public Role checkDuplicateRole(Role roleVerif) {
        if(roleDAO.get(roleVerif) == null) {
            roleDAO.create(roleVerif);
            return roleVerif;
        } else {
            return roleDAO.get(roleVerif);
        }
    }
}
