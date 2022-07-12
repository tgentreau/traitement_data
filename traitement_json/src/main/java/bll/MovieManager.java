package bll;

import bo.*;
import dal.DAOFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.stream.Collectors;

public class MovieManager {
    private static volatile MovieManager instance = null;
    EntityManager em = null;

    public MovieManager() {
        EntityManagerFactory emf = DAOFactory.getFactory();
        em = emf.createEntityManager();
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

    public LieuTournage getLieuTournage(String pays, String ville, String etat) {
        TypedQuery<LieuTournage> query = em.createQuery("select e from LieuTournage where e.pays = :pays and e.etat = :etat and e.ville = :ville", LieuTournage.class);
        query.setParameter("pays", pays);
        query.setParameter("etat", etat);
        query.setParameter("ville", ville);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public Pays getPays(String nom, String url) {
        TypedQuery<Pays> query = em.createQuery("select e from Pays where e.nom = :nom and e.url = :url", Pays.class);
        query.setParameter("nom", nom);
        query.setParameter("url", url);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public Acteur getActeur(String identite) {
        TypedQuery<Acteur> query = em.createQuery("select e from Acteur where e.identite = :identite", Acteur.class);
        query.setParameter("identite", identite);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public Realisateur getRealisateur(String identite) {
        TypedQuery<Realisateur> query = em.createQuery("select e from Realisateur where e.identite = :identite", Realisateur.class);
        query.setParameter("identite", identite);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public Genre getGenre(String nom) {
        TypedQuery<Genre> query = em.createQuery("select e from Genre where e.nom = :nom", Genre.class);
        query.setParameter("nom", nom);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public void addFilm(Film film) throws Exception {
        em.getTransaction().begin();
        LieuTournage lieuTournage = getLieuTournage(film.getLieuTournage().getPays(), film.getLieuTournage().getVille(),film.getLieuTournage().getEtat());
        Pays pays = getPays(film.getPays().getNom(), film.getPays().getUrl());

        try {
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
                        Acteur acteur = getActeur(a.getIdentite());
                        if(acteur != null) {
                            acteur.getFilms().add(film);
                            return acteur;
                        }
                        return a;
                    }).collect(Collectors.toList())
            );

            film.setRealisateurs(film.getRealisateurs().stream()
                    .map(r -> {
                        Realisateur realisateur = getRealisateur(r.getIdentite());
                        if(realisateur != null) {
                            realisateur.getFilms().add(film);
                            return realisateur;
                        }
                        return r;
                    }).collect(Collectors.toList())
            );

            film.setGenre(film.getGenre().stream()
                    .map(g -> {
                        Genre genre = getGenre(g.getNom());
                        if(genre != null) {
                            genre.getFilms().add(film);
                            return genre;
                        }
                        return g;
                    }).collect(Collectors.toList())
            );

            em.persist(film);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void addActeur(Acteur acteur) {
        em.getTransaction().begin();

    }
}
