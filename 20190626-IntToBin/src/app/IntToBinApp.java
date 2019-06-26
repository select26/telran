package app;

public class IntToBinApp {

	public static void main(String[] args) {

		System.out.println(dec2Binary(131));
		System.out.println(binaryToDec("1010"));
		System.out.println(dec2Binary(131.750, 0.0001));
	}
	
	public static int binaryToDec (String bynaryStr) {
		int pow2 = 1;
		int result = 0;
		for (int i = bynaryStr.length()-1; i >= 0; i--) {
			if (bynaryStr.charAt(i)=='1') result = result + pow2;
			pow2 = pow2 * 2;
		}
		return result;
	}
	
	public static String dec2Binary (int arg) {
		String result = "";
		int ost = 0;
		while (arg>0){
			ost = arg%2;
			arg = arg/2;
			result = ost + result;
		}
		return result;
	}
	
	public static String dec2Binary(double dec, double eps) {
		String result = "";
		int zel = (int)dec;
		result = dec2Binary(zel) + ".";
		int b = (int)dec;
		double drob = dec - b;
		
		double pow2 = 0.5;
		int ost = 0;
		while (pow2>eps) {
			result = result + (drob>= pow2 ? "1" : "0");
			if (drob>=pow2) drob = drob - pow2;
			pow2 = pow2 /2; 
		}
		return result;
	}

}
