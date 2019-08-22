package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import application.entities.CityEntity;
import application.entities.CountryEntity;

public interface CityJPARepository extends JpaRepository<CityEntity, Integer> {
	List<CityEntity> findByName(String cityName);
}
