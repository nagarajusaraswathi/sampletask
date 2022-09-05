package com.example.example.Task2.repository;

import com.example.example.Task2.model.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class Task2Reposotory {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create() {
         jdbcTemplate.execute(
                "create table parent(id varchar(10),parentid varchar(10),name varchar(100),color varchar(100))");
    }

    public int save(Parent parent) {
        return jdbcTemplate.update(
                "insert into parent (id ,parentid ,name ,color ) values(?,?,?,?)",
                parent.getId(), parent.getParentId(),parent.getName(),parent.getColor());
    }
    public Optional<Parent> findById(String id) {
        return jdbcTemplate.queryForObject(
                "select * from parent where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Parent(
                                rs.getString("id"),
                                rs.getString("parentid"),
                                rs.getString("name"),
                                rs.getString("color")
                        ))
        );
    }
    public List<Parent> findAll() {
        return jdbcTemplate.query(
                "select * from parent",
                (rs, rowNum) ->
                        new Parent(
                                rs.getString("id"),
                                rs.getString("parentid"),
                                rs.getString("name"),
                                rs.getString("color")
                        )
        );
    }


}
