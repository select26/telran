package app;

import java.util.ArrayList;

import dto.Firm;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import model.Business;

public class BusinessApp {

	public static void main(String[] args) {
//		Firm fm = Firm.randomFirm();
//		System.out.println(fm);
//		
//		Firm fm2 = Firm.randomFirm();
//		System.out.println(fm2);
		
		Business businessArray = new Business();
		businessArray.fill(10);
//		System.out.println(businessArray.allFirms());
		for (Firm frm : businessArray.allFirms()) System.out.println(frm);
		System.out.println("******************************************");
		for (Firm frm : businessArray.allFirmsByName("Omsktelecom")) System.out.println(frm);
	}
}
