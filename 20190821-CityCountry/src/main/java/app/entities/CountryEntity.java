package app.entities;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

import dto.City;
import dto.Country;

@Entity
@Table(name="country")
public class CountryEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_country;
	private String name;
	
	@OneToMany(mappedBy="country", cascade=CascadeType.ALL)
	@JsonManagedReference
	private Set<CityEntity> cities = new HashSet<CityEntity>();

	public CountryEntity(String name) {
		super();
		this.name = name;
//		this.cities = cities;
	}

	public CountryEntity(Country country) {
		this(country.getCountry());			//Тоже самое: name = country.getCountry();
	}
	
	public Country countryToCountryEntity(){
		return new Country(name, cities.stream());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_country;
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
		CountryEntity other = (CountryEntity) obj;
		if (id_country != other.id_country)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
