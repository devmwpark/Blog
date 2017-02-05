package com.blog.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @GetMapping
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("Hello World!!", HttpStatus.OK);
    }
}
