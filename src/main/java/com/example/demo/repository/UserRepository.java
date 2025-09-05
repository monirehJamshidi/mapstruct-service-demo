package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {

    private final Map<Long, User> store = new ConcurrentHashMap<>();
    private final AtomicLong idGen = new AtomicLong(0);

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idGen.incrementAndGet());
        }
        store.put(user.getId(), user);
        return user;
    }

    public void clear() {
        store.clear();
        idGen.set(0);
    }
}
