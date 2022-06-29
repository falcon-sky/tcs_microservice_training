package com.service.patient.patientservice.consumer;

import com.service.patient.patientservice.producer.ArtemisProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ArtemisConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArtemisConsumer.class);
    private final ArtemisProducer producer;

    public ArtemisConsumer(ArtemisProducer producer) {
        this.producer = producer;
    }

    @JmsListener(destination = "${jms.queue.request}")
    public void receive(String msg){
        System.out.println("Received Message to Patient Service: " + msg);
        String responseMessage="Sending response from Patient : "+msg;
        producer.send(responseMessage);
    }
}

