package application.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import application.entities.TeacherEntity;

public interface TeacherJpaRepository extends JpaRepository<TeacherEntity, Integer>{
	
}
