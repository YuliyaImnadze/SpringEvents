package com.example.springevents.processor;

import com.example.springevents.entity.TicketPayload;
import com.example.springevents.events.TicketEvent;
import com.example.springevents.events.TicketEventPublisher;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Random;
import java.util.UUID;

@Component
public class TicketEventProcessor {


    private final TicketEventPublisher publisher;

    @Autowired
    public TicketEventProcessor(TicketEventPublisher publisher) {
        this.publisher = publisher;
    }

    public TicketPayload process() {
        TicketPayload payload = new TicketPayload();
        payload.setId(UUID.randomUUID().toString());
        payload.setPin(StringUtils.leftPad(String.valueOf(new Random().nextInt(9999)),4, "0"));
        TicketEvent event = new TicketEvent(this,payload);
        publisher.publish(event);
        return payload;
    }

}