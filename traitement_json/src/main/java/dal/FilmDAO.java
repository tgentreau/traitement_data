package dal;

import bll.MovieManager;
import bo.Acteur;
import bo.Film;
import bo.Pays;

import javax.persistence.TypedQuery;
import java.util.List;

public class FilmDAO extends AbstractDAO implements DAO<Film>{
    @Override
    public Film get(Film data) {
        TypedQuery<Film> query = em.createQuery("select e from Film e where e.media.nom = :nom", Film.class);
        query.setParameter("nom", data.getMedia().getNom());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    //Affichage de la filmographie d’un acteur donné

    public List<Film> getFilmByActeurName(String nomActeur) {
        TypedQuery<Film> query = em.createQuery("select distinct e from Film e join e.acteurs a where a.personne.identite =:identite", Film.class);
        query.setParameter("identite", nomActeur);
        return query.getResultList();
    }

    //Affichage des films sortis entre 2 années données
    public List<Film> getFilmWithTwoYears(String annee1, String annee2) {
        TypedQuery<Film> query = em.createQuery("select e from Film e where e.media.anneeSortie >= :annee1 and e.media.anneeSortie <= :annee2", Film.class);
        query.setParameter("annee1", annee1);
        query.setParameter("annee2", annee2);
        return query.getResultList();
    }

    //Affichage des films communs à 2 acteurs/actrices donnés.
    public List<Film> getFilmsWithTwoGivenActors(String acteur1, String acteur2) {
        TypedQuery<Film> query = em.createQuery("select e from Film e join e.acteurs a where a.personne.identite = :acteur1 and a.personne.identite = :acteur2", Film.class);
        query.setParameter("acteur1", acteur1);
        query.setParameter("acteur2", acteur2);
        return query.getResultList();
    }

    //Affichage des acteurs communs à 2 films donnés

    //Affichage des films sortis entre 2 années données et qui ont un acteur/actrice donné au casting
}
