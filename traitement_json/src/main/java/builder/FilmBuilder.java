package builder;

import bo.*;
import dal.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilmBuilder {

    LieuTournageDAO lieuTournageDAO = new LieuTournageDAO();
    PaysDAO paysDAO = new PaysDAO();
    ActeurDAO acteurDAO = new ActeurDAO();
    RealisateurDAO realisateurDAO = new RealisateurDAO();
    GenreDAO genreDAO = new GenreDAO();
    FilmDAO filmDAO = new FilmDAO();
    PaysBuilder paysBuilder = new PaysBuilder();
    RealisateurBuilder realisateurBuilder = new RealisateurBuilder();

    GenreBuilder genreBuilder = new GenreBuilder();
    LieuTournageBuilder lieuTournageBuilder = new LieuTournageBuilder();

    ActeurBuilder acteurBuilder = new ActeurBuilder();

    public Film createOBJFilm(Object film) {
        Film filmToCreate = new Film();
        Map<String, Object> mapFilm = (Map) film;
        Medias medias = new Medias();

        medias.setNom((String) mapFilm.get("nom"));
        medias.setPlot((String) mapFilm.get("plot"));
        medias.setLangue((String) mapFilm.get("langue"));
        medias.setIdIMDB((String) mapFilm.get("id"));
        medias.setUrl((String) mapFilm.get("url"));
        medias.setAnneeSortie((String) mapFilm.get("anneeSortie"));
        filmToCreate.setMedia(medias);

        if(mapFilm.get("pays") != null) {
            filmToCreate.setPays(paysBuilder.createOBJPays(mapFilm.get("pays")));
        }

        List<Realisateur> realisateurList = new ArrayList<>();

        if(mapFilm.get("realisateurs") != null) {
            List<Object> listReal = (List<Object>) mapFilm.get("realisateurs");
            for (Object reals : listReal) {
                realisateurList.add(realisateurBuilder.createOBJReal(reals));
            }
        }
        filmToCreate.setRealisateurs(realisateurList);

        List<Genre> genreList = new ArrayList<>();
        if(mapFilm.get("genres") != null) {
            List<String> listGenre = (List<String>) mapFilm.get("genres");
            for (String genre : listGenre) {
                genreList.add(genreBuilder.createOBJGenre(genre));
            }
        }
        filmToCreate.setGenre(genreList);

        if(mapFilm.get("lieuTournage") != null) {
            filmToCreate.setLieuTournage(lieuTournageBuilder.createOBJLieu(mapFilm.get("lieuTournage")));
        }


        return checkDuplicateFilm(filmToCreate);
    }

    public Film checkDuplicateFilm(Film film) {
        if(filmDAO.get(film) == null) {
            filmDAO.create(film);
            return film;
        } else {
            return filmDAO.get(film);
        }
    }
}
