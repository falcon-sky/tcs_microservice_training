package com.service.patient.patientservice.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ArtemisConsumer {
    @JmsListener(destination = "${jms.queue.request}")
    public void receive(String msg){
        System.out.println("Got Message: " + msg);
    }
}

