package application.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.entities.CityEntity;
import application.entities.CountryEntity;
import application.service.ICityCountry;
import dto.City;
import dto.Country;

@RestController
public class CountryCityController {
	@Autowired
	ICityCountry service;
	
	
	@PostMapping("/addCountry")
	public boolean addCountry(@RequestParam String countryName) {
		return service.addCountry(countryName);
	}
	
	@PostMapping("/addCity")
	public boolean addCity(@RequestParam String cityName, @RequestParam String countryName) {
		return service.addCity(cityName, countryName);
	}
	
	@GetMapping("/GetCountryByCity")
	public List<String> getCountryByCity(@RequestParam String cityName) {
		return service.getCountry(cityName).stream().map(CountryEntity->CountryEntity.getName()).collect(Collectors.toList());
	}
	
//	@GetMapping("/GetCitiesByCountry")
//	public List<String> GetCitiesByCountry(@RequestParam String countryName) {
//		return service.getCitiesByCountry(countryName).stream().map(cityEntity->cityEntity.getName()).collect(Collectors.toList());
//	}
	
	@GetMapping("/GetCitiesByCountry")
	public ResponseEntity<Set<City>> getCitiesByCountry(@RequestParam String countryName){
		return new ResponseEntity<>(service.getCitiesByCountry(countryName).stream().map(CityEntity :: getCity).collect(Collectors.toSet()),HttpStatus.OK);
	}
	
	@DeleteMapping("/removeCountry")
	public ResponseEntity<String> removeCountry(@RequestParam String countryName) {
		return service.removeCountry(countryName);
		
	}
	

}
