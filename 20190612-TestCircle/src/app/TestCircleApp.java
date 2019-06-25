package app;

import lib.Circle;
import lib.Point;

//import java.awt.Point;

public class TestCircleApp {

	public static void main(String[] args) {
		Point point1 = new Point(1, 1);			// Центры окружностей
		Point point2 = new Point(2, 5);
		Point point3 = new Point(2, 3);
		
		Point point4 = new Point(2, 6);			// Точка, которую проверяем на принадлежность окружностям
		Point point5 = new Point(1, 2);
		Point point6 = new Point(4, 4);
		
		Circle circle1 = new Circle(point1, 4);
		Circle circle2 = new Circle(point2, 3);
		Circle circle3 = new Circle(point3, 3);
		
//		if (circle1.isInside(point4)) {
//			System.out.println("point4 inside circle1");
//		}
		
		if (isPointInside3Circles(circle1, circle2, circle3, point4)) {
			System.out.println("Bingo! Point4 is in all circles!");
		} else {
			System.out.println("Point4 is not in all circles now!");
		}

		if (isPointInside3Circles(circle1, circle2, circle3, point5)) { 
			System.out.println("Bingo! Point5 is in all circles!");
		} else {
			System.out.println("Point5 is not in all circles now!");
		}

		if (isPointInside3Circles(circle1, circle2, circle3, point6)) {
			System.out.println("Bingo! Point6 is in all circles!");
		} else {
			System.out.println("Point6 is not in all circles now!");
		}
		
	}
	
	public static boolean isPointInside3Circles(Circle circle1, Circle circle2, Circle circle3, Point point) {
		return (circle1.isInside(point) && circle2.isInside(point) && circle3.isInside(point));
	}

}
