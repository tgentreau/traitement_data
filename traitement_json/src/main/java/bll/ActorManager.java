package bll;

import bo.Acteur;
import dal.ActeurDAO;

import java.util.List;

public class ActorManager {
    private static volatile ActorManager instance = null;

    private ActeurDAO acteurDAO = new ActeurDAO();

    public ActorManager() {
    }

    /**
     * Singleton acteur manager
     * @return instance Actor Manager
     */
    public static final ActorManager getInstance() {
        if(ActorManager.instance == null) {
            synchronized (ActorManager.class) {
                if(ActorManager.instance == null) {
                    ActorManager.instance = new ActorManager();
                }
            }
        }
        return ActorManager.instance;
    }

    public List<Acteur> getCastingByFilmName(String film) {
        return acteurDAO.getCastingByFilm(film);
    }

    public List<Acteur> getActorsWithTwoGivenFilms(String film1, String film2) {
        return acteurDAO.getActorsWithTwoGivenFilms(film1, film2);
    }
}
