package AbstractDataTypeandListADT;

public class Circle extends Shape {
	
	private double radius = 0;
	
	public Circle(double radius) {
		this.radius = radius;
		this.setName(this.getClass().getSimpleName());
	}
	
	@Override
	protected double getVolume() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(this.radius, 2) ;
	}

	@Override
	protected double getPerimeter() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * this.radius;
	}

}
