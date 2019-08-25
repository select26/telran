package application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import application.entities.GroupEntity;

public interface GroupJpaRepository extends JpaRepository<GroupEntity, String>{

}
