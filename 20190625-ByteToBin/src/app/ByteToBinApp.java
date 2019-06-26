package app;

public class ByteToBinApp {
	
	public static void main(String[] args) {
		boolean[] src = {true, false, true, false, false, false, false, false,
//						 true, false, true, false, false, false, true, false,
//						 false, false, true, false, false, false, false, false,
						 true, false, true, false, true, true };
		System.out.print("Src boolean: \t");
		for (boolean b : src) System.out.print(b + " ");							// print source boolean array
		System.out.println();
		
		byte[] dst = booleanToBinary(src);
		System.out.print("Dest. binary: \t");
		for (byte b : dst) System.out.print(Integer.toBinaryString(b) + " ");		// print destination binary array
		System.out.println();
		
		src = binaryToByte(dst);
		System.out.print("Dest. boolean: \t");
		for (boolean b : src) System.out.print(b + " ");							// print destination boolean array
	}
	
	public static boolean[] binaryToByte(byte[] arrByte) {
		
		int len = arrByte[0];
		boolean[] result = new boolean[len];
		int byteCount = 1;
		int bitCount = 0;
		for (int i = 0; i < len; i++) {
			if ( ( arrByte[byteCount] & (1<<bitCount) ) != 0) result[i] = true;
			bitCount++;
			if (bitCount>7) {
				bitCount = 0;
				byteCount++;
			}
		}
		return result;
	}
	
	public static byte[] booleanToBinary(boolean[] arrBool) {
		
		int len = arrBool.length;
		byte[] result = new byte[len/8 + 2];
		result[0] = (byte) len;														// Ð’ 0 Ñ�Ñ‡ÐµÐ¹ÐºÐµ - Ð´Ð»Ð¸Ð½Ð° Ð¸Ñ�Ñ…Ð¾Ð´Ð½Ð¾Ð³Ð¾ Ð¼Ð°Ñ�Ñ�Ð¸Ð²Ð°
		int byteCount = 1;
		int bitCount = 0;
		for (int i = 0; i < len; i++) {
			if (arrBool[i]==true) result[byteCount] = (byte)(result[byteCount] | (1<<bitCount));
			bitCount++;
			if (bitCount>7) {
				bitCount = 0;
				byteCount++;
			}
		}
		return result;
	}

}
