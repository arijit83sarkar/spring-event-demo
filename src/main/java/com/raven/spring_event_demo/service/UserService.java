package com.raven.spring_event_demo.service;

import com.raven.spring_event_demo.events.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public UserService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void registerUser(String userName, String email) {
        log.info("User '{}' with email '{}' registered successfully.", userName, email);

        // event published
        eventPublisher.publishEvent(new UserCreatedEvent(this, userName, email));
        log.info("User creation event published for {}", userName);
    }
}
