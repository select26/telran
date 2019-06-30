package lib;

import java.util.Random;

import randomlib.RandomLib;

public class BooksLib {

	private static final String[] AUTOR_SET = {"London J.", "Hainlain R.A.", "Twain M.", "Hemingway E.", "Krapivin V.", "Tolstoy A."};
	private static final String[] TITLE_SET = {"3 in boat", "Read Flower", "Double star", "Tom Sayer", "White Fang", "Aelita  "};
	private long ISBN;
	private String Author; 
	private	String Title;
	private int Year;
	private double Price;
	private boolean Pics;
	public BooksLib(long iSBN, String author, String title, int year, double price, boolean pics) {
		super();
		ISBN = iSBN;
		Author = author;
		Title = title;
		Year = year;
		Price = price;
		Pics = pics;
	}
	public BooksLib() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public boolean isPics() {
		return Pics;
	}
	public void setPics(boolean pics) {
		Pics = pics;
	}
	@Override
	public String toString() {
		return "[ ISBN=" + ISBN * 11111 + ", Author: " + Author + ", \tTitle: " + Title + ", \tYear: " + Year + ", \tPrice: "
				+ Price + ", \tPics:" + (Pics? "yes":"no") + " ]";
	}
	
	public static BooksLib randomBook() {
		String Author	= RandomLib.nextStringFromSet(AUTOR_SET); 
		String Title 	= RandomLib.nextStringFromSet(TITLE_SET);
		int Year 		= RandomLib.nextIntRange(1996, 2019);
		double Price	= RandomLib.nextIntRange(100, 2500) / 100.;
		boolean Pics	= RandomLib.nextRandomBoolean(.5);
		long ISBN		= RandomLib.nextIntRange(130_000_000, 550_000_000);
		
		return new BooksLib(ISBN, Author, Title, Year, Price, Pics);
	}

}
