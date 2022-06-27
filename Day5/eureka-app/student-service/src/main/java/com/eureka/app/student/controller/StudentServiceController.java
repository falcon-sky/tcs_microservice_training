package com.eureka.app.student.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.app.student.dto.Student;

@RestController
public class StudentServiceController {
 
    private static Map<String, List<Student>> schooDB = new HashMap<String, List<Student>>();
 
    static {
        schooDB = new HashMap<String, List<Student>>();
 
        List<Student> lst = new ArrayList<Student>();
        Student std = new Student("Student1", "Class1");
        lst.add(std);
        std = new Student("Student2", "Class2");
        lst.add(std);
 
        schooDB.put("School1", lst);
 
        lst = new ArrayList<Student>();
        std = new Student("Student3", "Class3");
        lst.add(std);
        std = new Student("Student4", "Class4");
        lst.add(std);
 
        schooDB.put("school2", lst);
 
    }
 
    @RequestMapping(value = "/getStudentDetailsForSchool/{schoolname}", method = RequestMethod.GET)
    public List<Student> getStudents(@PathVariable String schoolname) {
        System.out.println("Getting Student details for " + schoolname);
 
        List<Student> studentList = schooDB.get(schoolname);
        if (studentList == null) {
            studentList = new ArrayList<Student>();
            Student std = new Student("Not Found", "N/A");
            studentList.add(std);
        }
        return studentList;
    }
}