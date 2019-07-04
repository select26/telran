package app;

public class User implements ICarDriver, IPrintDriver{
	
//	public void foo() {
//		drive();
//	}

	@Override
	public void drive() {
		IPrintDriver.super.drive();
		ICarDriver.super.drive();
	}
}
