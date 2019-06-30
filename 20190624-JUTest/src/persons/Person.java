package persons;

public class Person implements Comparable<Person>{
	long id;
	String name;
	String city;
	
	public Person(long id2, String name, String city) {
		super();
		this.id = id2;
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + (int)id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Person ? this.id == ((Person)obj).id : false;
		

		
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Person other = (Person) obj;
//		if (city == null) {
//			if (other.city != null)
//				return false;
//		} else if (!city.equals(other.city))
//			return false;
//		if (id != other.id)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
	}

	@Override
	public int compareTo(Person o) {
		return Long.compare(this.id, o.id);
	}
	
}
