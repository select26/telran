package application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import application.entities.StudentEntity;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Integer>{

}
