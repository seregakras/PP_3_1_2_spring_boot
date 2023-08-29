package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();

    void add(User user);

    void update(User user);

    User findUserById(long id);

    void delete(User user);
}
