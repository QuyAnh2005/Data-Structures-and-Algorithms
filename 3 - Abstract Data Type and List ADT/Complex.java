package AbstractDataTypeandListADT;

import java.util.Scanner;

public class Complex {

	private float real; //phần thực
	private float image; //phần ảo
	
	public Complex(float r, float i) {
		// Hàm khởi tạo
		this.real = r;
		this.image = i;
	}
	
	// (matrix+bi) + (c+di) = (matrix+c) + (b+d)i
	public Complex add(Complex c) {
		// Hoàn thành hàm cộng số phức hiện tại với số phức c
		float real = this.real + c.real;
		float imaginary = this.image + c.image;		
		return new Complex(real, imaginary);
	}
	
	// (matrix+bi) - (c+di) = (matrix-c) + (b-d)i
	public Complex minus(Complex c) {
		// Hoàn thành hàm trừ số phức hiện tại cho số phức c
		float real = this.real - c.real;
		float imaginary = this.image - c.image;				
		return new Complex(real, imaginary);
	}
	
	// (matrix+bi)*(c+di) = ac-bd + (bc+ad)i
	public Complex time(Complex c) {
		// Hoàn thành hàm nhân số phức hiện tại với số phức c
		float real = this.real * c.real - this.image * c.image;
        float imaginary = this.real * c.image + this.image * c.real;
        return new Complex(real, imaginary);
	}
	
	public float realpart() {
		return real;
	}
	
	public float imagepart() {
		return image;
	}
	
	@Override
	public String toString() {
		// Hoàn thành hàm in ra số phức dạng matrix + bi
		if (image == 0) return real + "";
        if (real == 0) return image + "i";
        if (image <  0) return real + " - " + (-image) + "i";
        return real + " + " + image + "i";
	}
	
	// Function for take matrix complex number from keyboard
	public static Complex[] typeComplex(Scanner sc, int n) {
		Complex[] complexs = new Complex[n];
		for (int i=0; i<n; i++) {
			System.out.println();
			System.out.println("COMPLEX " + (i+1));
			// real part
			System.out.print("Real part: ");
			float real = Float.parseFloat(sc.nextLine());
			// image part
			System.out.print("Image part: ");
			float image = Float.parseFloat(sc.nextLine());
			// Add complex in array
			complexs[i] = new Complex(real, image);
		}
		return complexs;
	}
	
	// Function for summing all complexs
	public static Complex sumAll(Complex[] complexs) {
		Complex sum = complexs[0];
		for (int i=1; i<complexs.length; i++) {
			sum = sum.add(complexs[i]);
		}
		return sum;
	}
	
	// Function for print i-th complex number
	public static void printElement(int i, Complex[] complexs) throws IndexOutOfBoundsException{
		System.out.println(complexs[i].toString());
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many complex numbers: ");
		int n = Integer.parseInt(sc.nextLine());
		
		// type n complexs
		Complex[] complexs = typeComplex(sc, n);

		// sum all complex numbers
		System.out.println("\nSum all complex numbers in array: " + sumAll(complexs).toString() );
		
		//  Print i-th complex number in array
		System.out.print("\nYou want to print complex at position: ");
		int i = Integer.parseInt(sc.nextLine());
		printElement(i, complexs);
	}
	
	// APPLICATION: READ README.md

}
