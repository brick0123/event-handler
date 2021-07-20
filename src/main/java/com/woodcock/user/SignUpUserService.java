package com.woodcock.user;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpUserService {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher eventPublisher;

    public void register(final String email) {
        final User user = userRepository.save(new User(email));

        eventPublisher.publishEvent(new SignUpUserEvent(user));
    }
}
