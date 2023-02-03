package com.example.SpringBootCrud.Repository;

import com.example.SpringBootCrud.Domain.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Students , Long>{

}
