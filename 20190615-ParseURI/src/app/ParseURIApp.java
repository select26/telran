package app;

import java.sql.Array;
import java.util.Arrays;

public class ParseURIApp {

//		http://mySite/admin/andCustomer?name=Masha&age=18&weight=52
//		напечатать на консоли
//		{
//		uri : НАПИСАТЬ ВСЕ ДО ?
//		name : Masha,
//		age : 18,
//		weight : 52
//		}
	
	public static void main(String[] args) {
		String strOriginal  = "http://mySite/admin/andCustomer?name=Masha&age=18&weight=52&color=magenta&size=M&Color2=blue";

		// Parsing
		String[] URI = strOriginal.split("\\?");
		String[] paramsStr = URI[1].split("&");
//		System.out.println(Arrays.toString(paramsStr));
		
		// Output
		System.out.println("URI: \t" + URI[0]);
		System.out.println("Params:");
		for (int i = 0; i < paramsStr.length; i++) {
			String tmpStr[] = paramsStr[i].split("=");
			System.out.println(tmpStr[0] + ":\t" + tmpStr[1]);	
		}
	
	}

}
