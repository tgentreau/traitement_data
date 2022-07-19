package dal;

import bll.MovieManager;
import bo.Acteur;

import javax.persistence.TypedQuery;
import java.util.List;

public class ActeurDAO extends AbstractDAO implements DAO<Acteur>{
    /**
     * select un acteur en fonction de son identite via la classe Acteur
     * @param data
     * @return
     */
    @Override
    public Acteur get(Acteur data) {
        TypedQuery<Acteur> query = em.createQuery("select e from Acteur e where e.personne.identite = :identite", Acteur.class);
        query.setParameter("identite", data.getPersonne().getIdentite());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    /**
     * Affichage du casting d’un film donné
     * @param film
     * @return
     */
    public List<Acteur> getCastingByFilm(String film) {
        TypedQuery<Acteur> query = em.createQuery("select distinct a from Acteur a join a.castingPrincipal f where f.media.nom = :nom", Acteur.class);
        query.setParameter("nom", film);
        return query.getResultList();
    }

    /**
     * Affichage des acteurs communs à 2 films donnés
     * @param film1
     * @param film2
     * @return
     */
    public List<Acteur> getActorsWithTwoGivenFilms(String film1, String film2) {
        TypedQuery<Acteur> query = em.createQuery("select e from Acteur e join e.films f where f.media.nom = :film1 and e.id in (select a.id from Acteur a join a.films f2 where f2.media.nom = :film2)", Acteur.class);
        query.setParameter("film1", film1);
        query.setParameter("film2", film2);
        return query.getResultList();
    }
}
