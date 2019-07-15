package dto;

import java.time.LocalDate;
import java.util.Set;
import enumerations.Title;
import utils.Comparators;

public class Book implements Comparable<Book>{
	
	private long isbn;  // 13 digits
	private Set<Author> authors;
	private Title title;
	private LocalDate publishingDate;
	private Publisher publisher;
	private double price;        // 2 digits after dot	
	
	public Book() {}

	public Book(long isbn, Set<Author> authors, Title title, 
			LocalDate publishingDate, Publisher publisher, double price) {

		this.isbn = isbn;
		this.authors = authors;
		this.title = title;
		this.publishingDate = publishingDate;
		this.publisher = publisher;
		this.price = price;
	}

	public long getIsbn() {return isbn;}
	public void setIsbn(long isbn) {this.isbn = isbn;}

	public Set<Author> getAuthors() {return authors;}
	public void setAuthors(Set<Author> authors) {this.authors = authors;}

	public Title getTitle() {return title;}
	public void setTitle(Title title) {this.title = title;}

	public LocalDate getPublishingDate() {return publishingDate;}
	public void setPublishingDate(LocalDate publishingDate) {this.publishingDate = publishingDate;}

	public Publisher getPublisher() {return publisher;}
	public void setPublisher(Publisher publisher) {this.publisher = publisher;}

	public double getPrice() {return price;}
	public void setPrice(double price) {this.price = price;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + (int) (isbn ^ (isbn >>> 32));
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((publishingDate == null) ? 0 : publishingDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (isbn != other.isbn)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (publishingDate == null) {
			if (other.publishingDate != null)
				return false;
		} else if (!publishingDate.equals(other.publishingDate))
			return false;
		if (title != other.title)
			return false;
		return true;
	}

	@Override
	public int compareTo(Book other) {
		return Comparators.naturalBookComparator.compare(this, other);
	}

	@Override
	// TODO rewrite
	public String toString() {
		return isbn + "; " + authors + "; \"" + title.getValue() + "\", " + publishingDate
				+ "; " + publisher + "; " + price + "]";
	}
	
	
	
	
	

	
}
