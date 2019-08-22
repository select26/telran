package application.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import dto.City;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="city")
public class CityEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_city;
	private String name;
	
	@ManyToOne // many cities, one countryused to show type of connection
	@JsonBackReference //used to preserve recursion when creating JSON of city and country, BackReference - is used from the side of many cities to one country
	private CountryEntity countryEntity;

	public CityEntity(String name, CountryEntity country) {
		super();
		this.name = name;
		this.countryEntity = country;
	}
	
	
	 
	 public City getCity() {
		return new City(name, countryEntity.getCountry());
		 
	 }
	 
	public CityEntity(City city) {
		this(city.getCity(),new CountryEntity(city.getCountry()));
	}
	
	public CountryEntity getCountry() {
		 return countryEntity;
	 }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_city;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityEntity other = (CityEntity) obj;
		if (id_city != other.id_city)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
	
}
