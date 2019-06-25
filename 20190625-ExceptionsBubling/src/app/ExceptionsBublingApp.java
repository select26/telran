package app;

public class ExceptionsBublingApp {

	public static void main(String[] args) {
		f1();
		System.out.println("main finished");
	}

	private static void f1() {
		f2();
		System.out.println("f1() finished");
	}

	private static void f2() {
		String srt = "v123";
		int i = 0;
		try {
			i = Integer.parseInt(srt);
		} catch (NumberFormatException e) {
//			e.printStackTrace();
			i = 999999999;
		}
		System.out.println("f2() finished with i = " + i);
	}
}
