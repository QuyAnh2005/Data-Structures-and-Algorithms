package JavaReview;

//This is Staff Object that created to use generic array

public class Staff {
	private String name;
	private int age;
	private double salary;
	
	public Staff(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public int compareTo(Staff other) {
		if(this.getSalary() > other.getSalary()) return 1;
		else if(this.getSalary() < other.getSalary()) return -1;
		else return 0;
	}
	
	public String toString() {
		return String.format("Name: %s \tAge: %d \tSalary: %.2f", name, age, salary);
	}
	
}

