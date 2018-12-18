package com.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Supun Madhusanka on 12/18/2018.
 */
@RestController
@RequestMapping("/api")
public class AppController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> get() {
        return new ResponseEntity<String>("Rest API works.", HttpStatus.OK);
    }

}