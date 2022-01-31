package AbstractDataTypeandListADT;

public class Rectangle extends Shape {
	
	private double width = 0;
	private double height = 0;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
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
		return this.width * this.height;
	}

	@Override
	protected double getPerimeter() {
		// TODO Auto-generated method stub
		return 2 * (this.width + this.height);
	}

}
