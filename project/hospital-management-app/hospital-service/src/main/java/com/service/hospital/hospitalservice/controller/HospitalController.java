package com.service.hospital.hospitalservice.controller;

import com.service.hospital.hospitalservice.producer.ArtemisProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HospitalController.class);
    private final ArtemisProducer producer;

    public HospitalController(ArtemisProducer producer) {
        this.producer = producer;
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public ResponseEntity<String> produce(@RequestParam("msg") String msg) {
        try {
            producer.send(msg);
            return ResponseEntity.ok()

                    .body("message sent:"+msg);
        } catch (Exception e) {
            LOGGER.error("Exception while handling uplink message: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
