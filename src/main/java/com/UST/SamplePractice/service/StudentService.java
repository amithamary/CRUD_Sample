package com.UST.SamplePractice.service;

import com.UST.SamplePractice.exception.IDNotFoundException;
import com.UST.SamplePractice.exception.NameNotFoundException;
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
        Optional<Student> s = studentRepos.findById(id);
            if(s.isEmpty()){
                throw new IDNotFoundException("ID not found");
            }
            else{
                return s.get();
            }
    }


    public String deleteById(int id) {
        studentRepos.deleteById(id);
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

    public Student getAllstudentByName(String name) {
        Optional<Student> student = studentRepos.findByName(name);
        if(student.isEmpty()){
            throw new NameNotFoundException("name not found");
        }
        else{
            return student.get();
        }
    }
}
