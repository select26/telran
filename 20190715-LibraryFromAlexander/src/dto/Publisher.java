package dto;

import enumerations.PublisherCountry;
import enumerations.PublisherName;
import utils.Comparators;

public class Publisher implements Comparable<Publisher>{
	
	private String name;
	private String country;
	
	public Publisher() {}
	public Publisher(PublisherName name, PublisherCountry country) {
		this.name = name.getValue();
		this.country = country.toString();
	}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getCountry() {return country;}
	public void setCountry(String country) {this.country = country;}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
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
		Publisher other = (Publisher) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return country + ", " +name;
	}
	
	@Override
	public int compareTo(Publisher other) {
		return Comparators.publisherComparator.compare(this, other);
	}
	
}
