package com.UST.SamplePractice.controller;

import com.UST.SamplePractice.model.Student;
import com.UST.SamplePractice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/addstudent")
    public Student addAllStudent(@RequestBody Student student){
        return studentService.addAllStudent(student);
    }
    @GetMapping("/get")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    @GetMapping("/get/{id}")
    public Student getstudentById(@PathVariable int id){
        return studentService.getAllstudentById(id);
    }
    @PutMapping("/put")
    public Student updateById(@RequestBody Student student){
        return studentService.updateById(student);
    }
    @DeleteMapping("/delete")
    public String deleteById(@PathVariable int id){
        return studentService.deleteById(id);
    }



}
