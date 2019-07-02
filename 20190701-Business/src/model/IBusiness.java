package model;

import dto.Firm;

public interface IBusiness {
	
	void fill(int numFirm);
	
	boolean add(Firm firm);
	boolean contains(Firm firm);
	boolean remove(Firm firm);
	Firm remove(int inn);
	
	Firm getById(int inn);
	Iterable<Firm> allFirms();
	Iterable<Firm> allFirmsByName(String name); 
//	Iterable<Car> allFirmsByYearRange(int min, int max);
//	Iterable<Car> allCarsByEngineRange(double min, double max);
//	Iterable<Car> allCarsByAC(boolean ac);
//	
//	Iterable<Car> allCarsSortedByModel();
//	Iterable<Car> allCarsSortedByYear();
//	Iterable<Car> allCarsSortedByEngine();
}
