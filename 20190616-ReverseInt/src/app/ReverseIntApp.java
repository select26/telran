package app;

public class ReverseIntApp {

	public static void main(String[] args) {
		System.out.println(reverse(123456987));
	}
	
	public static int reverse (int num) {
		int result = 0;
		while (num != 0){
			result = result * 10 + ( num % 10 );
			num = num / 10;
		}
		return result;
	}

}
