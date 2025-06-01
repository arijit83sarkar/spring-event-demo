package com.raven.spring_event_demo.events;

import org.springframework.context.ApplicationEvent;

public class UserCreatedEvent extends ApplicationEvent {
    private final String userName;
    private final String email;

    public UserCreatedEvent(Object source, String userName, String email) {
        super(source);
        this.userName = userName;
        this.email = email;
    }

    public String userName() {
        return userName;
    }

    public String email() {
        return email;
    }

    @Override
    public String toString() {
        return "UserCreatedEvent{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
