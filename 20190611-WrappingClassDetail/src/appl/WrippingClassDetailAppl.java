package appl;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class WrippingClassDetailAppl {

	public static void main(String[] args) {
//		System.out.println(Double.MAX_VALUE);
//		System.out.println(Double.MAX_EXPONENT);
//		System.out.println(Double.MIN_NORMAL);
//		
//		System.out.println(Long.toBinaryString(
//				Double.doubleToLongBits(3000000000.)));
		
		double sam = 1./3.;
		System.out.println(sam);
		System.out.println(cutTwo(sam));
	}
	
	
	public static double cutTwo(double orig) {
		return ( (int) (orig * 100.) ) /100.;
	}
	
}
