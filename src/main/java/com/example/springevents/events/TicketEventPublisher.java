package com.example.springevents.events;

import com.example.springevents.events.TicketEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class TicketEventPublisher  {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish (TicketEvent event) {
        // можно сюда всю логику из процессора
        this.applicationEventPublisher.publishEvent(event);
    }
}
