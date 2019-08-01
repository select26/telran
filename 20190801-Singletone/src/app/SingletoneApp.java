package app;

public class SingletoneApp {

	public static void main(String[] args) {
		SingletonePersonEnum.Sasha.setName("Pasha");
		System.out.println(SingletonePersonEnum.Sasha.getName());
	}
}
