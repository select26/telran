package app;

public class MemoryLimitApp {

	public static void main(String[] args) {
		int[] arr;
		
		int left = 0;
		int right = Integer.MAX_VALUE/7;
		
//		try {
//			arr = new int[right];
//			System.out.println("Your computer is excellent enough!");
//			return;
//		} catch (Error e) {
//			System.out.println("Requested array size exceeds VM limit");
//			e.printStackTrace();
//		} 
		
		int middle = 0;
		while (right - left > 1) {
//			arr = null;
			middle = left + (right - left) / 2;
			
			try {
				arr = new int [middle];
				left = middle;
			} catch (Error e) {
				right = middle;
			}
		}
		System.out.println(left * 4 /1024/1024);
	}

}
