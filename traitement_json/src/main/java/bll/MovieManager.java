package bll;

import bo.*;
import builder.ActeurBuilder;
import builder.FilmBuilder;
import dal.DAOFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class MovieManager {
    private static volatile MovieManager instance = null;
     static EntityManager em = null;

    public MovieManager() {
    }

    public final EntityManager getConnection() {
        EntityManagerFactory emf = DAOFactory.getFactory();
        em = emf.createEntityManager();
        return em;
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

    public void insertFilm(Film film) {
        em.getTransaction().begin();
        FilmBuilder filmBuilder = new FilmBuilder();
        Film filmCreated = filmBuilder.createObjFilm(film);
         em.persist(filmCreated);
         em.getTransaction().commit();
    }

    public void addActeur(Acteur acteur) {
        em.getTransaction().begin();
        ActeurBuilder acteurBuilder = new ActeurBuilder();
        Acteur acteurCreated = acteurBuilder.createObjActeur(acteur);
        em.persist(acteurCreated);
        em.getTransaction().commit();
    }
    public void addRole(Role role) {
        em.getTransaction().begin();
        em.persist(role);
        em.getTransaction().commit();
    }
}
