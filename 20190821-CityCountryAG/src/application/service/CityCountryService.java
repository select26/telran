package application.service;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import application.entities.CityEntity;
import application.entities.CountryEntity;
import application.repository.CityJPARepository;
import application.repository.CountryJPARepository;

@Service
public class CityCountryService implements ICityCountry{
	@Autowired
	CityJPARepository cityRepo;
	
	@Autowired
	CountryJPARepository countryRepo;
	
	
	@Override
	public boolean addCountry(String countryName) {
	if(countryRepo.findByName(countryName).size()>0) return false;
	
	countryRepo.save(new CountryEntity(countryName));
	return true;
	}

	@Override
	public boolean addCity(String name, String country) {
		List<CountryEntity> countryFound = countryRepo.findByName(country);
		if (countryFound.size()==0) {
			addCountry(country);
			countryFound = countryRepo.findByName(country);
		}
		cityRepo.save(new CityEntity(name, countryFound.get(0)));
		return true;
	}

	@Override
	public ResponseEntity<String> removeCountry(String countryName) {
		List<CountryEntity> countryFound=countryRepo.findByName(countryName);
		if(countryFound.size()==0) return new ResponseEntity<>("NoCountry",HttpStatus.BAD_REQUEST);
		if(countryFound.get(0).getCities().size()>0) return new ResponseEntity<>("NoCity",HttpStatus.I_AM_A_TEAPOT);;
		countryRepo.deleteAll(countryFound);
		 return new ResponseEntity<>("OK",HttpStatus.OK);
	}

	@Override
	public List<CountryEntity> getCountry(String cityName) {
		List<CityEntity> cityFound = cityRepo.findByName(cityName);
		HashSet<CountryEntity> result = new HashSet<>();
		for(CityEntity city: cityFound) result.add(city.getCountry());
		ArrayList<CountryEntity> ali=new ArrayList<CountryEntity>(result);
		
		return ali;
	}

	@Override
	public List<CityEntity> getCitiesByCountry(String countryName) {
		List<CountryEntity> countryFound=countryRepo.findByName(countryName);
		if(countryFound.size()==0) return new ArrayList<CityEntity>();
		return new ArrayList<CityEntity>(countryFound.get(0).getCities());
	}

}
