package app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.TeacherEntity;

public interface TeacherUniRepo extends JpaRepository<TeacherEntity, Integer>{
	List<TeacherEntity> findByFirstNameAndLastName(String firstName, String lastName);
}
