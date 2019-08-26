package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.CompanyEntity;

public interface CompanyJpaRepository extends JpaRepository<CompanyEntity, Integer>{

}
