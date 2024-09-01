package com.javajdbc.javajdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javajdbc.javajdbc.model.Student;
import com.javajdbc.javajdbc.repo.StudentRepo;

@Service
public class StudentService {

    private StudentRepo repo;
    public void addStudent(Student s)   
    {
        repo.save(s);
        System.out.println("Added");
    }
    public StudentRepo getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public List<Student> getStudents()
    {
        return repo.findAll();
    }

    
}
