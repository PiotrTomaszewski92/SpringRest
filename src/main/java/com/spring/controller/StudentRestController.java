package com.spring.controller;
import com.spring.entity.Student;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    //Define @PostConstruct to load data ... ONLY ONCE!
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Piotr","Piotrowski"));
        students.add(new Student("Adam","Adamowski"));
        students.add(new Student("Karol","Trzaska"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if (studentId >= students.size() || studentId < 0)
            throw new StudentNotFoundException("Student id not found - "+studentId);
        return students.get(studentId);
    }
}

