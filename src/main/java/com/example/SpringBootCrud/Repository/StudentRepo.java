package com.example.SpringBootCrud.Repository;

import com.example.SpringBootCrud.domain.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Students , Long>{

}
