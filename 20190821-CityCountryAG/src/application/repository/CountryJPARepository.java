package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import application.entities.CountryEntity;

public interface CountryJPARepository extends JpaRepository<CountryEntity, Integer>{

	List<CountryEntity> findByName(String countryName);

}
