package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void add(User user);

    void update(User user);

    User findUser(long id);

    void delete(long id);
}
