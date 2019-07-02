package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

import dto.Firm;

public class Business implements IBusiness{
	
	private HashMap<Long, Firm> catalogHM = new HashMap<>();
	private TreeMap<String, TreeSet<Firm>> nameTM = new TreeMap<>(); 

	@Override
	public void fill(int numFirm) {
		for (int i = 0; i < numFirm; i++) add(Firm.randomFirm());
	}

	@Override
	public boolean add(Firm firm) {
		long inn = firm.getTaxNumber();
		if (catalogHM.containsKey(inn)) return false;
		else {
			catalogHM.put(inn, firm);
			
			String nameFirm =  firm.getName();					// Name of Firm
			TreeSet<Firm> modelTS = nameTM.get(nameFirm);
			if (modelTS==null) modelTS = new TreeSet<Firm>();
			modelTS.add(firm);
			nameTM.put(nameFirm, modelTS);
			
			return false;
		}
	}

	@Override
	public boolean contains(Firm firm) {
		return catalogHM.containsKey(firm.getTaxNumber());
	}

	@Override
	public boolean remove(Firm firm) {
		if (firm == null) return false;
		boolean result = ( catalogHM.remove(firm.getTaxNumber()) != null);
		
		if (result) {
			nameTM.get(firm.getName()).remove(firm);
		}
		
		return result;
	}

	@Override
	public Firm remove(int inn) {
		if (catalogHM.containsKey(inn)) { 
			Firm del = catalogHM.get(inn); 
			remove(del);
			return del;
			}
		else return null;
	}

	@Override
	public Firm getById(int inn) {
		return catalogHM.get(inn);
	}

	@Override
	public Iterable<Firm> allFirms() {
		return new ArrayList<Firm>(catalogHM.values());
	}

	@Override
	public Iterable<Firm> allFirmsByName(String name) {
		TreeSet<Firm> result = nameTM.get(name);
		return result == null ? new TreeSet<Firm>() : result; 
	}

	@Override
	public String toString() {
		ArrayList<Firm> tmp = (ArrayList<Firm>) allFirms();
		String result = "";
		for (int i = 0; i < tmp.size(); i++) result = result + tmp.get(i) + "\n";
		return result;
	}
	
	

}
