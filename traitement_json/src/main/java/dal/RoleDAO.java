package dal;

import bll.MovieManager;
import bo.Role;

import javax.persistence.TypedQuery;

public class RoleDAO extends AbstractDAO implements DAO<Role>{

    @Override
    public Role get(Role data) {
        TypedQuery<Role> query = em.createQuery("select e from Role e where e.characterName = :characterName", Role.class);
        query.setParameter("characterName", data.getCharacterName());
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
    public void create(Role role) {
        em.getTransaction().begin();
        em.persist(role);
        em.getTransaction().commit();
    }
}
