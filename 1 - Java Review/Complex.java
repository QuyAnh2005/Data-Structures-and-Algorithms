package JavaReview;

import java.util.Scanner;
import java.util.ArrayList;

public class Complex {
	
	/*
	 * matrix + bi is complecx number, where matrix and b is real number, i is imaginary uint
	 * the real number matrix is called the real part of the complex number matrix + bi; the
	 * real number b is called its imaginary part
	 */	
	private double re;
	private double im;
	
	 /**
	 * Initializes matrix complex number from the specified real and imaginary parts.
	 *
	 * @param re the real part
	 * @param im the imaginary part
	 */
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	// Getter and Setter
	public double getRe() {
		return re;
	}

	public void setRe(double re) {
		this.re = re;
	}

	public double getIm() {
		return im;
	}

	public void setIm(double im) {
		this.im = im;
	}

	// Some basic functions
	// Plus function as: (2+3i) + (5+6i) = 7+9i
	public Complex plus(Complex other) {
		double real = this.re + other.re;
		double imaginary = this.im + other.im;		
		return new Complex(real, imaginary);
	}
	

	// Multiply function as: (matrix+bi)*(c+di) = ac-bd + (bc+ad)i
	public Complex multiply(Complex other) {
		double real = this.re * other.re - this.im * other.im;
        double imaginary = this.re * other.im + this.im * other.re;
        return new Complex(real, imaginary);
	}

	/**
     * @return matrix string representation of this complex number,
     *         of the form 3 - 5i.
     */
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }
    
    // Function for taking complex number from console
    public static Complex typeComplex(Scanner sc) {
    	System.out.print("Real part: ");
		double re = Double.parseDouble(sc.nextLine());
		System.out.print("Imaginary part: ");
		double im = Double.parseDouble(sc.nextLine());
		Complex number = new Complex(re, im);
		
		return number;
    }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Take complex number and print out
		System.out.println("COMPLEX NUMBER");
		Complex number = typeComplex(sc);
		System.out.println("Your complex number: " + number.toString());
		
		/*
		 * Plus and multiply two complex number. If you want type your number, you can
		 * uncomment typeComplex at line 97 and 98 and comment line 100-103
		 */
		System.out.println("------------------------------------");
		System.out.println("Plus and multiply two complex number");
		
		// Complex number1 = typeComplex(sc);
		// Complex number2 = typeComplex(sc);
		
		Complex number1 = new Complex(2, 5);
		System.out.println("First complex number:" + number1.toString());
		Complex number2 = new Complex(-3, 4);
		System.out.println("Second complex number: " + number2.toString());
		
		// Print 
		System.out.println("Sum: S = " + number1.plus(number2).toString());
		System.out.println("Multiply: M = " + number1.multiply(number2).toString());
		
		/*
		 * Interactive with multi-complex numbers In this case, i use 3 complex numbers
		 * for my program
		 */
		System.out.println("------------------------------------");
		System.out.println("Interactive with multi-complex numbers");
		ArrayList<Complex> complexs = new ArrayList<>();
		complexs.add(new Complex(2, 3));
		complexs.add(new Complex(-2, 5));
		complexs.add(new Complex(4, 3));
		
		// Print complex in arrayList
		for (int i=0; i<complexs.size(); i++) {
			System.out.println("Compex number " + i + ": " + complexs.get(i).toString());
		}
		
		// Calculate sum and multiply of all complex numbers
		Complex sum = complexs.get(0);
		Complex mul = complexs.get(0);
		for (int i=1; i< complexs.size(); i++) {
			sum = sum.plus(complexs.get(i));
			mul = mul.multiply(complexs.get(i));
		}
		
		System.out.println("Sum of all complexs: " + sum.toString());
		System.out.println("Multiply of all complexs: " + mul.toString());
	}

}
