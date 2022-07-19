package bll;

import bo.*;
import builder.ActeurBuilder;
import builder.FilmBuilder;
import builder.RoleBuilder;
import dal.*;

import java.util.List;

public class MovieManager {
    private static volatile MovieManager instance = null;

    private ActeurDAO acteurDAO = new ActeurDAO();
    private FilmDAO filmDAO = new FilmDAO();
    private RoleDAO roleDAO = new RoleDAO();
    private GenreDAO genreDAO = new GenreDAO();
    private LieuTournageDAO lieuTournageDAO = new LieuTournageDAO();
    private NaissanceDAO naissanceDAO = new NaissanceDAO();
    private PaysDAO paysDAO = new PaysDAO();
    private RealisateurDAO realisateurDAO = new RealisateurDAO();

    public MovieManager() {
    }

    public static final MovieManager getInstance() {
        if(MovieManager.instance == null) {
            synchronized (MovieManager.class) {
                if(MovieManager.instance == null) {
                    MovieManager.instance = new MovieManager();
                }
            }
        }
        return MovieManager.instance;
    }

    public List<Film> getFilmsByActorName(String acteur) {
        return filmDAO.getFilmByActeurName(acteur);
    }

    public List<Acteur> getCastingByFilmName(String film) {
        return acteurDAO.getCastingByFilm(film);
    }

    public List<Film> getFilmBetweenTwoYears(String annee1, String annee2) {
        return filmDAO.getFilmWithTwoYears(annee1, annee2);
    }

    public List<Film> getFilmsWithTwoGivenActors(String acteur1, String acteur2) {
        return filmDAO.getFilmsWithTwoGivenActors(acteur1, acteur2);
    }
}
