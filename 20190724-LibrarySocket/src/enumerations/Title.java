package enumerations;

public enum Title {
	HellAndParadise("Hell and Paradise"),
	SkyAndMount("Sky and Mount"),
	SeaAndCloud("Sea and Cloud"),
	CreekAndRiver("Creek and River"),
	FrogAndSnake("Frog and Snake"),
	EagleAndRat("Eagle and Rat"),
	TomatoAndPotato("Tomato and Potato"),
	StrawberryAndGarlic("Strawberry and Garlic"),
	SunAndMoon("Sun and Moon"),
	WindAndRain("Wind and Rain");
	
	String value;

	private Title(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	

}
