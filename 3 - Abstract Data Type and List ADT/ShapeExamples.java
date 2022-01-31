package AbstractDataTypeandListADT;

import java.util.ArrayList;

public class ShapeExamples {

	public static void main(String[] args) {
		
		ArrayList<Shape> shape = new ArrayList<>();
		
		// Initial some shapes and add to array
		Circle c = new Circle(3.5);
		Sphere s = new Sphere(2.5);
		Rectangle r = new Rectangle(2, 3);
		
		shape.add(c);
		shape.add(s);
		shape.add(r);
		
		printOut(shape);

	}
	
	public static void printOut(ArrayList<Shape> shape) {
		for (int i=0; i<shape.size(); i++) {
			Shape element = shape.get(i);
			String name = element.getName();
			System.out.println("\n" + name);
			if (name.equals("Sphere")) {
				System.out.println("Area: " + element.getArea());
				System.out.println("Volume: " + element.getVolume());
			} else {
				System.out.println("Area: " + element.getArea());
				System.out.println("Volume: " + element.getPerimeter());
			}
		}
	}
	
	// APPLICATION: READ README.mdWordCountApplication

}
