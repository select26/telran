package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.ChildEntity;

public interface ChildJpaRepository extends JpaRepository<ChildEntity, Integer>{

}
