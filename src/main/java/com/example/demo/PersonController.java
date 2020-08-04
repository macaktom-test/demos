package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestMapping("api")
@RestController
public class PersonController {

    @GetMapping(value = "/people", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPeople(){
        return Stream.of(new Person("Petr", 14), new Person("Tom", 15))
                    .sorted((o2, o1) -> o1.getAge() - o2.getAge())
                    .collect(Collectors.toList());
    }
}
