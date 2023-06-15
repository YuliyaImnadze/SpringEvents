package com.example.springevents.controller;

import com.example.springevents.entity.TicketPayload;
import com.example.springevents.processor.TicketEventProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

    @Autowired
    private TicketEventProcessor eventProcessor;

    @GetMapping("/generate")
    public String generateTicket() {
        System.out.println("Start: " + new Date());
        TicketPayload payload = eventProcessor.process();
        System.out.println("Finish: " + new Date());
        return String.format("Ticket %s generated with pin %s!", payload.getId(),payload.getPin());
//        String.format("Ticket %s generated with pin %s at %s", payload.getId(),
//                payload.getPin(), new Date()));
    }
}
