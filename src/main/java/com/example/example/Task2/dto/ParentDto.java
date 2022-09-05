package com.example.example.Task2.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class ParentDto {
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ParentDto> subClasses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParentDto> getSubClasses() {
        return subClasses;
    }

    public void setSubClasses(List<ParentDto> subClasses) {
        this.subClasses = subClasses;
    }
}
