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

    public Role createOBJRole(Object role) {
        Role roleToCreate = new Role();

        Map<String, Object> mapRole = (Map) role;

        roleToCreate.setCharacterName((String) mapRole.get("characterName"));

        roleToCreate.setFilm(filmBuilder.createOBJFilm(mapRole.get("film")));

        return checkDuplicateRole(roleToCreate);
    }


    public Role checkDuplicateRole(Role roleVerif) {
        /*System.out.println(role);
        Acteur acteur = acteurDAO.get(role.getActeur());
        Film film = filmDAO.get(role.getFilm());

        if(acteur != null) {
            role.setActeur(acteur);
            acteur.getRoles().add(role);
        }

        if(film != null) {
            role.setFilm(film);
            film.getRoles().add(role);
        }
*/
        if(roleDAO.get(roleVerif) == null) {
            roleDAO.create(roleVerif);
            return roleVerif;
        } else {
            return roleDAO.get(roleVerif);
        }
    }
}
