package com.service.hospital.hospitalservice.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ArtemisConsumer {
    @JmsListener(destination = "${jms.queue.response}")
    public void receive(String msg){
        System.out.println("Got Message: " + msg);
    }
}

