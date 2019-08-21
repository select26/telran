package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.CountryEntity;

public interface CountryJpaRepo extends JpaRepository<CountryEntity, Integer>{}
