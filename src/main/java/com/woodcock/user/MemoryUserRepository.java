package com.woodcock.user;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryUserRepository implements UserRepository {

    private static final Map<Long, User> store = new ConcurrentHashMap<>();
    private static final AtomicLong SEQUENCE = new AtomicLong();

    @Override
    public User save(final User user) {
        if (user.getId() == null) {
            user.setId(SEQUENCE.incrementAndGet());
        }
        store.put(user.getId(), user);
        return user;
    }
}
