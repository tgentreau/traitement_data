package bll;

import bo.*;
import builder.ActeurBuilder;
import builder.FilmBuilder;
import builder.RoleBuilder;
import dal.DAOFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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

    public void createFilm(Film film) {
        getConnection();
        em.getTransaction().begin();
        FilmBuilder filmBuilder = new FilmBuilder();
        Film filmCreated = filmBuilder.createObjFilm(film);
         em.persist(filmCreated);
         em.getTransaction().commit();
    }

    public void createActeur(Acteur acteur) {
        getConnection();
        em.getTransaction().begin();
        ActeurBuilder acteurBuilder = new ActeurBuilder();
        Acteur acteurCreated = acteurBuilder.createObjActeur(acteur);
        em.persist(acteurCreated);
        em.getTransaction().commit();
    }
    public void createRole(Role role) {
        getConnection();
        em.getTransaction().begin();
        RoleBuilder roleBuilder = new RoleBuilder();
        Role roleCreated = roleBuilder.createObjRole(role);
        em.persist(role);
        em.getTransaction().commit();
    }
}
