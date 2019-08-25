package application.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import application.entities.BookEntity;

public interface BookJpaRepository extends JpaRepository<BookEntity,Integer>{
	List<BookEntity> findByTitle(String title);
}
