package ru.netology.SpringBootAuthorization.repository;

import org.hibernate.validator.constraints.ModCheck;
import ru.netology.SpringBootAuthorization.controller.Authorities;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {

    private final ConcurrentHashMap<String, String> data = new ConcurrentHashMap<>(Map.of("Ivan", "1111", "Peter", "2222",
            "Alex", "3333", "Gordon", "4444"));

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (!data.containsKey(user)) {
            return Collections.emptyList();
        }

        return List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
    }
}
