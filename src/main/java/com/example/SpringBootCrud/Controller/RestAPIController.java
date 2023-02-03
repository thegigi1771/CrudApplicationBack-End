package com.example.SpringBootCrud.Controller;

import com.example.SpringBootCrud.Domain.Students;
import com.example.SpringBootCrud.Service.StudentService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestAPIController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Students> getAllStudents() {return studentService.findAll();}

    @GetMapping("/student/{id}")
    public Students getStudentByID(@PathVariable int id) {return studentService.findById(Long.valueOf(id));}

    @PostMapping("/addStudent")
    public void addUser(@RequestBody Students student){studentService.save(student);}

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudentByID(@PathVariable int id) {studentService.delete(Long.valueOf(id));}

    @PutMapping("/updateStudent/{id}")
    public void updateStudentByID(@RequestBody Students user) {
        studentService.save(user);
    }
}
