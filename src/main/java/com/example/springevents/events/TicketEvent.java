package com.example.springevents.events;

import com.example.springevents.entity.TicketPayload;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class TicketEvent extends ApplicationEvent {

    private TicketPayload payload;

    public TicketEvent(Object source, TicketPayload payload) {
        super(source);
        this.payload = payload;
    }

    public TicketPayload getPayload() {
        return this.payload;
    }
}
