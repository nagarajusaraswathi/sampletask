package com.example.example.Task2.controller;

import com.example.example.Task2.dto.ParentDto;
import com.example.example.Task2.model.Parent;
import com.example.example.Task2.service.Task2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class Task2Controller {
    @Autowired
    private Task2Service task2Service;

    @GetMapping("/parents/{id}")
    public ResponseEntity getParent(@PathVariable String id)  {
       try {
           ParentDto parent = task2Service.getById(id);
           return  new ResponseEntity<ParentDto>(parent, HttpStatus.OK);
       }catch (Exception e){
          return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
       }

    }
    @GetMapping("/parentsall")
    public List<ParentDto> getAllParent() throws Exception {

        return task2Service.getAll();
    }
}
