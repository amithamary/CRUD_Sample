package com.UST.SamplePractice.service;

import com.UST.SamplePractice.model.Student;
import com.UST.SamplePractice.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    public StudentRepo studentRepos;
    public Student addAllStudent(Student student) {
        return studentRepos.save(student);
    }
    public List<Student> getAllStudent() {
        return studentRepos.findAll();
    }
    public Student getAllstudentById(int id) {
        return studentRepos.findById(id).orElse(null);
    }


    public String deleteById(int id) {
        return ("deleted");
    }

    public Student updateById(Student student) {
        Student old = null;
        Optional<Student> students = studentRepos.findById(student.getId());
        if(students.isPresent()) {
            old = students.get();
            old.setName(student.getName());
            old.setEmail(student.getEmail());
            old.setRollno(student.getRollno());
            studentRepos.save(old);
        }
        else{
            return new Student();
        }
        return old;
    }
}
