package com.example.example.task1.controller;

import com.example.example.task1.model.Person;
import com.example.example.task1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PersonController {
    @Autowired
  PersonService personService;
    @GetMapping("/serviceone")
    public ResponseEntity get(){
        ResponseEntity responseEntity = new ResponseEntity("Hello", HttpStatus.OK);
        return responseEntity;
    }
    @PostMapping("/servicetwo")
    public ResponseEntity<String> post(@RequestBody Person person){
        try {
            String res = personService.serciveTwo(person);
           return new ResponseEntity(res,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/servicethree")
    public ResponseEntity<String> postForServiceThree(@RequestBody Person person){
        try {
            String res = personService.serviceThree(person);
            return new ResponseEntity(res,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
