package app.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entities.CarEntity;

public interface CarJpaRepo extends JpaRepository<CarEntity, Integer>{
	
	List<CarEntity> findByModel(String model);		//Spring  добавит новый запрос по фразе 'fibdBy'
													//и будет искать по 'Model'
	List<CarEntity> findByEngineBetween(double from, double to);
	List<CarEntity> findByModelOrderByEngine(String model);
	
	@Query(value="select * from (SELECT * FROM car ORDER BY id DESC LIMIT ?1) as q1 ORDER BY production_date", nativeQuery = true)
	List<CarEntity> findByQuery(int num);
	
	List<CarEntity> findByModelAndEngineAndAcAndProductionDate(String model, double engine, boolean ac, LocalDate date);
	List<CarEntity> findByProductionDate(LocalDate date);
}
