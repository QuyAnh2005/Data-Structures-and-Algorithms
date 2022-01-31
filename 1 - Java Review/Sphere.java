package JavaReview;

public class Sphere {
	
	/* Sphere has the center at (x,y,z) and radius r */	
	private double r, x, y, z;
	
	public Sphere(double r, double x, double y, double z) {
		this.r = r;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// Getter and Setter of parameters
	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	public String toString() {
		return String.format("Sphere has center at (%.2f, %.2f, %.2f) and R = %.2f", x, y, z, r);
	}

	// Function for calculating surrounding area of ​​the sphere
	public double area() {
		return 4 * Math.PI * this.r * this.r;
	}
	
	// Function for calculating volume of sphere
	public double volume() {
		return 4 / 3 * Math.PI * Math.pow(this.r, 3);
	}
	
	// Function for calculating distance of two centers of two spheres
	public double distance(Sphere that) {
		double d_square = Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
		+ Math.pow(this.z - that.z, 2);
		return Math.sqrt(d_square);
	}
	
	// Function for checking of the sphere with another sphere
	public String status(Sphere that) {
		double d = this.distance(that);
		double minus = Math.abs(this.r - that.r);
		double plus = this.r + that.r;
		if (d > minus && d < plus) return "Intersection";
		if (d == minus || d == plus) return "Contact";
		if (d < minus) return "Contain";
		return "Not intersection";
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sphere A = new Sphere(3, 0, 0, 0);
		Sphere B = new Sphere(2, 0, 0, 0);
		
		// Print information of A sphere
		System.out.println(A.toString());
		
		// Print area and volume of A sphere
		System.out.println("Surrounding area: " + A.area());
		System.out.println("Volume: " + A.volume());
		
		// Check intersection of two sphere
		System.out.println("------------------------");
		System.out.println(B.toString());
		System.out.println("Status of two spheres: " + A.status(B));
	}

}
