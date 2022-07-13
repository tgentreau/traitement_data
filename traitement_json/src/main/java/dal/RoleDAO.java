package dal;

import bll.MovieManager;
import bo.Role;

import javax.persistence.TypedQuery;

public class RoleDAO implements DAO<Role>{

    MovieManager service = MovieManager.getInstance();
    @Override
    public Role get(Role data) {
        TypedQuery<Role> query = service.getConnection().createQuery("select e from Role where e.characterName = :characterName", Role.class);
        query.setParameter("characterName", data.getCharacterName());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
