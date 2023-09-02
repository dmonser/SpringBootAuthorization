package ru.netology.SpringBootAuthorization.controller;

import org.springframework.stereotype.Service;
import ru.netology.SpringBootAuthorization.excetion.InvalidCredentials;
import ru.netology.SpringBootAuthorization.excetion.UnauthorizedUser;
import ru.netology.SpringBootAuthorization.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    private AuthorizationService (UserRepository repository) {
        this.userRepository = repository;
    }

    List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
