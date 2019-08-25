package application.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import application.entities.AuthorEntity;

public interface AuthorJpaRepository extends JpaRepository<AuthorEntity, Integer>{
	List<AuthorEntity> findByName(String name);
}
