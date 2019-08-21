package app.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import dto.City;
import dto.Country;
import lombok.EqualsAndHashCode;

//@EqualsAndHashCode{of = {"id"}}
@Entity
@Table(name="city")
public class CityEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_city;
	
	private String name;
	
	@ManyToOne
	@JsonBackReference
	private Country country;

	public CityEntity(String name, CountryEntity country) {
		super();
		this.name = name;
		this.country = country;
	}

//	public CityEntity(City city) {
//		this(city.getCity(), city.getCountry());
//	}

	public CityEntity(City city){
		this(city.getCity(), new CountryEntity(city.getCountry()));
	}
	
	public City
	
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
