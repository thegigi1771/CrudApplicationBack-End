package com.example.SpringBootCrud.Service;

import com.example.SpringBootCrud.Repository.StudentRepo;
import com.example.SpringBootCrud.domain.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Students> findById (Long id) {return repo.findById(id);}
}
