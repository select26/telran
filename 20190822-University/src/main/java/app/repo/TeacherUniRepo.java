package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.TeacherEntity;

public interface TeacherUniRepo extends JpaRepository<TeacherEntity, Integer>{

}
