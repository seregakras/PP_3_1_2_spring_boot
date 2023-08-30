package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
@Transactional// todo: используем @Transactional на все методы Hibernate.. тогда, проставляем - над классом
                //todo: стоит разобраться с параметризированной @Transactional(...) https://www.baeldung.com/spring-transactions-read-only  например, 4.2
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public User findUser(long id) {
        return userDAO.findUserById(id);
    }

    @Override
    public void delete(long id) {
        User user = userDAO.findUserById(id);
        userDAO.delete(user);//todo валидация (что произойдет.. если User-а с id нет)
    }
}
