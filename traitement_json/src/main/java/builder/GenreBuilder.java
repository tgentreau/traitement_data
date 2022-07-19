package builder;

import bo.Genre;
import bo.Pays;
import dal.GenreDAO;

import java.util.ArrayList;
import java.util.List;

public class GenreBuilder {
    GenreDAO genreDAO = new GenreDAO();

    /**
     * Création de l'objet genre
     * @param genre
     * @return
     */
    public Genre createOBJGenre(String genre) {
        Genre genreToCreate = new Genre();
        genreToCreate.setNom(genre);
        return checkDuplicateGenre(genreToCreate);
    }

    /**
     * Verification de doublons dans la bdd et persist du genre
     * @param genre
     * @return
     */
    public Genre checkDuplicateGenre(Genre genre) {
        if(genreDAO.get(genre) == null) {
            genreDAO.create(genre);
            return genre;
        } else {
            return genreDAO.get(genre);
        }
    }
}
