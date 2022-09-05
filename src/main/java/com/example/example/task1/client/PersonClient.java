package com.example.example.task1.client;

import com.example.example.task1.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class PersonClient {
  @Value("${rest.serviceone}")
   public String url1;
    @Value("${rest.servicetwo}")
   public  String url2;

    public String serviceOnceClient() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> responseEntity = new RestTemplate().exchange(
                url1, HttpMethod.GET, entity, String.class);
        if(responseEntity.getStatusCode()!=HttpStatus.OK){
            throw new Exception("Service Failed");
        }
        return responseEntity.getBody();
    }
    public String serviceTwoClient(Person person) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Person> entity = new HttpEntity<Person>(person,headers);

        ResponseEntity<String> responseEntity =   new RestTemplate().exchange(
                url2, HttpMethod.POST, entity, String.class);
        if(responseEntity.getStatusCode()!=HttpStatus.OK){
            throw new Exception("Service Failed");
        }
        return responseEntity.getBody();
    }
}
