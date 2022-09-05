package com.example.example.task1.service;

import com.example.example.task1.client.PersonClient;
import com.example.example.task1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonClient personClient;
    public String serciveTwo(Person person) throws Exception {
        if((person.getName()==null || person.getName().isEmpty())|| (person.getSurname() == null || person.getSurname().isEmpty())){
            throw new Exception(" invalid data");
        }
        else {
            return person.getName()+" "+ person.getSurname();
        }
    }

    public String serviceThree(Person person) throws Exception {
        return personClient.serviceOnceClient()+personClient.serviceTwoClient(person);

    }


}
