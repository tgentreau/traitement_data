package dal;

import bll.MovieManager;
import bo.Acteur;

import javax.persistence.TypedQuery;
import java.util.List;

public class ActeurDAO extends AbstractDAO implements DAO<Acteur>{
    @Override
    public Acteur get(Acteur data) {
        TypedQuery<Acteur> query = em.createQuery("select e from Acteur e where e.personne.identite = :identite", Acteur.class);
        query.setParameter("identite", data.getPersonne().getIdentite());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    //Affichage du casting d’un film donné

    public List<Acteur> getCastingByFilm(String film) {
        TypedQuery<Acteur> query = em.createQuery("select e from Acteur e join e.roles r where r.film.media.nom = :nom", Acteur.class);
        query.setParameter("nom", film);
        return query.getResultList();
    }



    public void create(Acteur acteur) {
        em.getTransaction().begin();
        em.persist(acteur);
        em.getTransaction().commit();
    }
}
