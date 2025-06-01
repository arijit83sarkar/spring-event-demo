package com.raven.spring_event_demo.service;

import com.raven.spring_event_demo.events.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    @EventListener
    public void handleUserCreatedEvent(UserCreatedEvent userCreatedEvent) {
        log.info("NotificationService: Received UserCreatedEvent for user: {}", userCreatedEvent.userName());

        // add required logic here
        log.info("NotificationService: Sending welcome email to {} for {}", userCreatedEvent.email(), userCreatedEvent.userName());
    }

    // You can also listen for multiple events or specific conditions
    @EventListener
    public void handleAnyApplicationEvent(ApplicationEvent event) {
        // This listener will catch ALL Spring application events
        // System.out.println("NotificationService: Caught a general event: " + event.getClass().getSimpleName());
    }
}
