package com.example.example;

import com.example.example.Task2.dto.ParentDto;
import com.example.example.Task2.model.Parent;
import com.example.example.Task2.repository.Task2Reposotory;
import com.example.example.Task2.service.Task2Service;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class ExampleApplication implements CommandLineRunner {
    @Autowired
   private Task2Reposotory task2Reposotory;
    @Autowired
    private Task2Service task2Service;
	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        task2Reposotory.create();
        task2Reposotory.save(new Parent("1","0","Warrior","red"));
        task2Reposotory.save(new Parent("2","0","Wizard","green"));
        task2Reposotory.save(new Parent("3","0","Priest","white"));
        task2Reposotory.save(new Parent("4","0","Rogue","yellow"));
        task2Reposotory.save(new Parent("5","1","Fighter","blue"));
        task2Reposotory.save(new Parent("6","1","Paladin","lighblue"));
        task2Reposotory.save(new Parent("7","1","Ranger","lighgreen"));
        task2Reposotory.save(new Parent("8","2","Mage","grey"));
        task2Reposotory.save(new Parent("9","2","SpeciallistWizard","lightgrey"));
        task2Reposotory.save(new Parent("10","3","Cleric","red"));
        task2Reposotory.save(new Parent("11","3","Druid","green"));
        task2Reposotory.save(new Parent("12","3","Priest of specific mythos","white"));
        task2Reposotory.save(new Parent("13","4","Thief","yellow"));
        task2Reposotory.save(new Parent("14","4","Bard","blue"));
        task2Reposotory.save(new Parent("15","13","Assassin","lighblue"));

        Optional<Parent> optional = task2Reposotory.findById("1");
        Map<String , List<Parent>> map = task2Reposotory.findAll().stream().filter(parent -> parent.getParentId()!="0").collect(Collectors.groupingBy(Parent::getParentId));
        ParentDto parentDto = new ParentDto();
        List<ParentDto> parentDtos = task2Service.findAllSubClases(optional.get().getId(),map);
        parentDto.setSubClasses(parentDtos);

        if(optional.isPresent()){
            optional.get();
        }
    }
}
