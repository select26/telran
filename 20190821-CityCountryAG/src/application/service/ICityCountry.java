package application.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import application.entities.CityEntity;
import application.entities.CountryEntity;

public interface ICityCountry {
	
	boolean addCountry(String name);
	boolean addCity(String name,String country);
	ResponseEntity<String> removeCountry(String name);
	List<CountryEntity> getCountry(String cityName);
	List<CityEntity> getCitiesByCountry(String countryName);
	
	
}
