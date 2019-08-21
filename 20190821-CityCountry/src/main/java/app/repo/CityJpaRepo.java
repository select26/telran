package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.CityEntity;

public interface CityJpaRepo extends JpaRepository<CityEntity, Integer>{

}
