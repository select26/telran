package lib;

public class Circle {
	
	private Point center;
	private int radius;

	public Circle() {
		super();
	}
	
	public Circle(Point center, int radius) {
		super();
		this.center = center;
		this.radius = radius;
	}

	public Circle(int x, int y, int radius) {
//		Point center = new Point();
		this.center.setX(x);
		this.center.setY(y);
//		this.center = center;
		this.radius = radius;
	}
	
//  Определяет, лежит ли точка point внутри Circle. Если точка лежит на окружности,
//	считается, что она лежит внутри.
	public boolean isInside(Point point) {
		int rasst = (int) Math.sqrt((this.center.getX() - point.getX()) * (this.center.getX() - point.getX())
				+ (this.center.getY() - point.getY()) * (this.center.getY() - point.getY()));
		if (rasst <= this.radius)
			return true;
		else
			return false;
	}
}
