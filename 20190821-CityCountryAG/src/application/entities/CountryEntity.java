package application.entities;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import dto.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="country")
public class CountryEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Country;
	
	private String name;
	// one country to many cities
	//mapped by - creates foreign keys with countryEntity
	//cascade - type of connection between tables in case of changing/deleting country - changes/deleting cities
	@OneToMany(mappedBy="countryEntity", cascade=CascadeType.ALL)
	@JsonManagedReference //used to preserve recursion when creating JSON of city and country, ManagedReference - is used from the side of one to many
	private Set<CityEntity> cities = new HashSet<>(); //should be set of data
	
	
	//constructor hashcode and equals creates without link to another object - city to prevent recursion
	public CountryEntity(String name) {
		super();
		this.name = name;
		
	}
	
	public String getName() {
		return name;
	}

		public CountryEntity(Country country) {
			this(country.getCountry());
		}
		
		public Country getCountry() {
			return new Country(name);
		}
	 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_Country;
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
		if (id_Country != other.id_Country)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
