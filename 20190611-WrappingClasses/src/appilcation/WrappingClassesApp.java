package appilcation;

public class WrappingClassesApp {

	public static void main(String[] args) {

		int i =3;
		
		Integer ii = new Integer (i);
		Integer jj = i;
		Integer kk = (Integer)i;

		System.out.println(jj);

		String str = "101";
		System.out.println(Integer.parseInt(str,2));
		
		
	}

}
