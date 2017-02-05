package com.blog.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

@RestController
@Slf4j
@RequestMapping(value = "/home")
public class HomeController {

    @GetMapping
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("Hello World!!", HttpStatus.OK);
    }

    @PutMapping(value = "/create")
    public ResponseEntity putHome(@RequestBody  final String body){
        return new ResponseEntity(body,HttpStatus.CREATED);
    }

}
