package AbstractDataTypeandListADT;

public class Sphere extends Shape {
	
	private double radius = 0;
	
	public Sphere(double radius) {
		this.radius = radius;
		this.setName(this.getClass().getSimpleName());
	}
	
	@Override
	protected double getVolume() {
		// TODO Auto-generated method stub
		return 4 / 3 * Math.PI * Math.pow(radius, 3);
	}

	@Override
	protected double getArea() {
		// TODO Auto-generated method stub
		return 4 * Math.PI * Math.PI;
	}

	@Override
	protected double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

}
