package bll;

import bo.*;
import builder.ActeurBuilder;
import builder.FilmBuilder;
import builder.RoleBuilder;
import dal.*;

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

    public void createFilm(Film film) {
        FilmBuilder filmBuilder = new FilmBuilder();
        Film filmCreated = filmBuilder.checkDuplicateFilm(film);
        filmDAO.create(filmCreated);
    }

    public void createActeur(Acteur acteur) {
        ActeurBuilder acteurBuilder = new ActeurBuilder();
        Acteur acteurCreated = acteurBuilder.checkDuplicateActor(acteur);
        acteurDAO.create(acteurCreated);
    }
    public void createRole(Role role) {
        RoleBuilder roleBuilder = new RoleBuilder();
        Role roleCreated = roleBuilder.createOBJRole(role);
        roleDAO.create(roleCreated);
    }
//
//    public void createPays(Pays pays) {
//        getConnection();
//        em.getTransaction().begin();
//        em.persist(pays);
//        em.getTransaction().commit();
//    }
//
//    public void createLieuTournage(LieuTournage lieuTournage) {
//        getConnection();
//        em.getTransaction().begin();
//        em.persist(lieuTournage);
//        em.getTransaction().commit();
//    }
//
//    public void createNaissance(Naissance naissance) {
//        getConnection();
//        em.getTransaction().begin();
//        em.persist(naissance);
//        em.getTransaction().commit();
//    }
//
//    public void createGenre(Genre genre) {
//        getConnection();
//        em.getTransaction().begin();
//        em.persist(genre);
//        em.getTransaction().commit();
//    }
//
//    public void createRealisateur(Realisateur realisateur) {
//        getConnection();
//        em.getTransaction().begin();
//        em.persist(realisateur);
//        em.getTransaction().commit();
//    }
}
