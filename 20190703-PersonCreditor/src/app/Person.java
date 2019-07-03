package app;

public class Person implements Comparable{
	private String name;
	private Person creditor;
	private int numOfCreditors;
	
	public int getNumOfCreditors() {
		return numOfCreditors;
	}

	public void setNumOfCreditors(int numOfCreditors) {
		this.numOfCreditors = numOfCreditors;
	}

	public Person(String name, Person creditor) {
		super();
		this.name = name;
		this.creditor = creditor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getCreditor() {
		return creditor;
	}

	public void setCreditor(Person creditor) {
		this.creditor = creditor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creditor == null) ? 0 : creditor.hashCode());
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
		Person other = (Person) obj;
		if (creditor == null) {
			if (other.creditor != null)
				return false;
		} else if (!getCreditor().getName().equals(other.getCreditor().getName()))
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
		return "name=" + this.getName() + ", creditor=" + this.getCreditor().getName() + "\n";
	}

	public int compareTo(Object o) {
		int result = 0;
		Person other = (Person)o;
		result = this.getName().compareTo(other.getName());
		if (result != 0) return result;
		else return this.getCreditor().getName().compareTo(other.getName());
	}
}
