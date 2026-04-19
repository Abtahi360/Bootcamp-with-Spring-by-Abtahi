package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;
    // define @PostConstruct to load the student data ... only once..!
    @PostConstruct
    public void localData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Abtahi", "Islam"));
        theStudents.add(new Student("Jack", "Sam"));
        theStudents.add(new Student("Rain", "Madison"));
        theStudents.add(new Student("Jack", "Radison"));
    }


    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }
    

}
