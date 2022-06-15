package com.rama.training;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @GetMapping("/app/hello")
    public String getHello(){
        return "hello from app";
    }

    @GetMapping("/app/welcome")
    public String getwel(){
        return "welcome from app";
    }
}
