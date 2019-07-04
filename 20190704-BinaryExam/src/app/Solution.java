package app;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println(solution(2, 2));
		
	}
	
	public static int solution(int A, int B) {
		return countOnes(B*A);
	}

	public static int countOnes(int n) {
		int count = 0;
		while (n > 0) {
			if ((n & 1)!=0) count++;
			n = n>>1;
		}
		return count;
	}
}
