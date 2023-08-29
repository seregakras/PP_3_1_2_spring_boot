package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        TypedQuery<User> query = entityManager.createQuery(new String("from User"), User.class);
        return (query.getResultList() == null) ? Collections.emptyList() : query.getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }
}
