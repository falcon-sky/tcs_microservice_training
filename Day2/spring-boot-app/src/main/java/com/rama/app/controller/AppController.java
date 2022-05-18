package com.rama.app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {	
	    @RequestMapping("/")
	    public String index() {
	        return "Hello from controller";
	    }

		@GetMapping("/data")
		public String indexdata() {
			return "getting data from controller";
		}

		@PostMapping("/post")
		public String indexpost() {
			return "getting post from controller";
		}

	     @PutMapping("/put")
	     public String indexput() {
		return "getting put from controller";
	}

}
