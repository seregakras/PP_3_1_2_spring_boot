package org.serega.service;

import org.serega.model.User;
import org.serega.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User> {

    public UserService(UserRepository repository) {
        super(repository);
    }
}
