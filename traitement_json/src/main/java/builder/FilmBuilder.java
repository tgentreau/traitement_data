package builder;

import bo.*;
import dal.*;

import java.util.stream.Collectors;

public class FilmBuilder {

    LieuTournageDAO lieuTournageDAO = new LieuTournageDAO();
    PaysDAO paysDAO = new PaysDAO();
    ActeurDAO acteurDAO = new ActeurDAO();
    RealisateurDAO realisateurDAO = new RealisateurDAO();
    GenreDAO genreDAO = new GenreDAO();

    public Film createObjFilm(Film film) {
        LieuTournage lieuTournage =  lieuTournageDAO.get(film.getLieuTournage());
        Pays pays = paysDAO.get(film.getPays());

        //Gestion des doublons
        if(lieuTournage != null) {
            film.setLieuTournage(lieuTournage);
            lieuTournage.getFilms().add(film);
        }

        if(pays != null) {
            film.setPays(pays);
            pays.getFilms().add(film);
        }

        film.setActeurs(film.getActeurs().stream()
                .map(a -> {
                    Acteur acteur = acteurDAO.get(a);
                    if(acteur != null) {
                        acteur.getFilms().add(film);
                        return acteur;
                    }
                    return a;
                }).collect(Collectors.toList())
        );

        film.setRealisateurs(film.getRealisateurs().stream()
                .map(r -> {
                    Realisateur realisateur = realisateurDAO.get(r);
                    if(realisateur != null) {
                        realisateur.getFilms().add(film);
                        return realisateur;
                    }
                    return r;
                }).collect(Collectors.toList())
        );

        film.setGenre(film.getGenre().stream()
                .map(g -> {
                    Genre genre = genreDAO.get(g);
                    if(genre != null) {
                        genre.getFilms().add(film);
                        return genre;
                    }
                    return g;
                }).collect(Collectors.toList())
        );
        return film;
    }
}
