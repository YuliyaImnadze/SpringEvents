package com.example.springevents.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TicketEventPublisher  {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public TicketEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish (TicketEvent event) {
        // можно сюда всю логику из процессора
        this.applicationEventPublisher.publishEvent(event);
    }
}
