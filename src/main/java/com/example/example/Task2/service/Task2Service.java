package com.example.example.Task2.service;

import com.example.example.Task2.dto.ParentDto;
import com.example.example.Task2.model.Parent;
import com.example.example.Task2.repository.Task2Reposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Task2Service {
    @Autowired
    Task2Reposotory task2Reposotory;
    public ParentDto getById(String id) throws Exception {
        List<Parent> parentList = task2Reposotory.findAll();
        Optional<Parent> optionalParent  = parentList.stream().
                filter(parent -> parent.getId().equals(id)).findAny();
        if(optionalParent.isPresent()){
         Map<String, List<Parent>> listMap = parentList.stream().
                 filter(parent -> parent.getParentId()!="0").collect(Collectors.groupingBy(Parent::getParentId));
         ParentDto parentDto = new ParentDto();
         parentDto.setName(optionalParent.get().getName());
         parentDto.setSubClasses(findAllSubClases(optionalParent.get().getId(),listMap));
         return parentDto;
        } else {
            throw new Exception("Parent not found");
        }

    }
    public List<ParentDto> getAll() throws Exception {
        List<Parent> parentList = task2Reposotory.findAll();
        List<Parent> parents = parentList.stream().filter(parent -> parent.getParentId()=="0").
                collect(Collectors.toList());
        Map<String,List<Parent>> map = parentList.stream().
                filter(parent -> parent.getParentId()!="0").collect(Collectors.groupingBy(Parent::getParentId));
      return   parents.stream().map(parent -> {
            ParentDto parentDto = new ParentDto();
            parentDto.setName(parent.getName());
            parentDto.setSubClasses(findAllSubClases(parent.getId(),map));
            return parentDto;
        }).collect(Collectors.toList());

    }
    public List<ParentDto> findAllSubClases(String id , Map<String ,List<Parent>> map){
        if(map.containsKey(id)) {
            List<Parent> parentList = map.get(id);
            List<ParentDto> parentDtos = new ArrayList<>();
            for (Parent parents : parentList){
                ParentDto parentDto1 = new ParentDto();
                parentDto1.setName(parents.getName());
                parentDto1.setSubClasses(findAllSubClases(parents.getId(),map));
                parentDtos.add(parentDto1);
            }
          return parentDtos;

        } else {
           return null;
        }

    }

}
