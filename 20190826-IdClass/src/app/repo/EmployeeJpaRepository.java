package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.EmployeeEntity;
import app.entities.EmployeeId;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, EmployeeId> {

}
