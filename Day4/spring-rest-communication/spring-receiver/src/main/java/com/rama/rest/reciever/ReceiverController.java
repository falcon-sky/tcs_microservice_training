package com.rama.rest.reciever;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiverController {
  private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverController.class);

  @GetMapping("/receiver/get")
  public String getDetail() {
    LOGGER.info("Receiver request:");
    return "Data from receiver";
  }
}
