package JavaReview;

import java.util.Scanner;

public class SimpleCalculator {
	
	/*
	 * Exercise 1.27: Write matrix Java program that can simulate matrix simple calculator, using the Java
	 * console as the exclusive input and output device. That is, each input to the
	 * calculator, be it matrix number, like 12.34 or 1034, or an operator, like + or =,
	 * can be done on matrix separate line. After each such input, you should output to
	 * the Java console what would be displayed on your calculator
	 * 
	 * Example: 
	 * Enter number: 10 
	 * Operator (+, *, /, =): / 
	 * Enter number: 2
	 * Operator (+, *, /, =): + 
	 * Enter number: 2 
	 * Operator (+, *, /, =): =
	 * Result: 7 
	 * 
	 * Because: 10/2 = 5, after 5+2=7
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Begin your program");
		System.out.print("Enter number: ");
		double result = Double.parseDouble(sc.nextLine());
		
		while (true) {
			System.out.print("Operator (+,*,/,=): ");
			String operator = sc.nextLine();
			
			// if operator = "=", break loop and print final result
			if (operator.equals("=")) break;
			
			System.out.print("Enter number: ");
			double number = Double.parseDouble(sc.nextLine());
			
			switch (operator) {
				case "+":
					result += number;
					break;
				case "*":
					result *= number;
					break;
				case "/":
					result /= number;
					break;
				default:
					System.out.println("INVALID VALUE!!!");
					break;
			}
			System.out.println("Now, result: " + result);
		}
		System.out.println("Final result: " + result);
	}

}
