package com.example.SpringBootCrud.Service;

import com.example.SpringBootCrud.Repository.StudentRepo;
import com.example.SpringBootCrud.Domain.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional; // pour utiliser Optional<Students>

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;

    public void save (Students students) {
        repo.save(students);
    }

    public List<Students> findAll () {
        return repo.findAll();
    }

    public void delete (Long id) {
        repo.deleteById(id);
    }

    public Students findById (Long id) {return repo.findById(id).orElse(null);}
}
