package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.*;

public interface StudentUniRepo extends JpaRepository<StudentEntity, Integer>{

}
