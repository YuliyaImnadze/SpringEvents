package com.example.springevents.events;

import com.example.springevents.entity.TicketPayload;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TicketEventListener {

    @EventListener
    public void onApplicationEvent(TicketEvent event) {
        logEvent(event.getPayload());
    }

    private void logEvent(TicketPayload payload) {
        System.out.println(String.format("Ticket %s generated with pin %s at %s", payload.getId(),
                payload.getPin(), new Date()));
    }


}
