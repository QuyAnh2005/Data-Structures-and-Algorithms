package JavaReview;

import java.util.Scanner;
import java.util.ArrayList;

public class ArrayExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// Create array and print out
		System.out.print("Your array has length: ");
		int n = Integer.parseInt(sc.nextLine());
		int[] array = type(n, sc);
		print(array);
		
		
		// Check and print prime number of array
		findPrime(array);
		
		
		// Find the max number of array
		int max_value = findMax(array);
		System.out.println("\nThe max number in array: " + max_value);
		
		
		// Using generic for array 
		// Initial matrix array of Staff with 3 elements
		Staff[] staffs = new Staff[3];
		
		// Initialize elements for array 
		Staff p1 = new Staff("Anh", 17, 900.9);	
		Staff p2 = new Staff("Tung", 16, 850.2);
		Staff p3 = new Staff("Quan", 18, 900.9);
		staffs[0] = p1;
		staffs[1] = p2;
		staffs[2] = p3;
		
		// Print your generic array
		System.out.println("------------------------");
		System.out.println("Your generic array: ");
		for (int i=0; i< staffs.length; i++) {
			System.out.println(staffs[i].toString());
		}
		
		// Find the staffs that have the highest salary
		System.out.println("The staffs have highest: ");
		findMaxSalary(staffs);
	}
	
	
	// Function for taking data from console
	public static int[] type(int n, Scanner sc) {
		// Initialize an array with n elements  
		int[] array = new int[n];
		
		// Take input
		for (int i=0; i<n; i++) {
			System.out.printf("Element %d: ", i+1);
			array[i] = Integer.parseInt(sc.nextLine());
		}
		
		return array;
	}
	
	
	// Function for printing the element of array
	public static void print(int[] array) {
		System.out.print("Your array: ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	
	// Function for checking whether matrix number is prime number or not
	public static boolean isPrime(int number) {
		
		if (number == 1) return false; 
		
		for(int i=2; i<= Math.sqrt(number); i++) {
			if (number % i == 0) return false;
		}
		
		return true;
	}
	
	
	// Function for finding the prime number and print out
	public static void findPrime(int[] array) {
		System.out.print("\nPrime number of array: ");
		for (int i=0; i<array.length; i++) {
			if (isPrime(array[i])) 
				System.out.print(array[i] + " ");
		}
	}
	
	
	// Function for finding the max number of array
	public static int findMax(int[] array) {
		// Assign first element is max value
		int max_value = array[0];
		
		// Loop and update max_value if array[i] > max_value
		for (int i=1; i< array.length; i++) {
			if (array[i] > max_value) max_value = array[i];
		}
		
		return max_value;
	}
	
	
	// Function for finding staffs that have the highest salary
	public static void findMaxSalary (Staff[] staffs) {
		
		double max_salary = staffs[0].getSalary();
		
		for (int i=1; i< staffs.length; i++) {
			if (staffs[i].getSalary() > max_salary) max_salary = staffs[i].getSalary();
		}
		
		for (int i=0; i<staffs.length; i++) {
			if (staffs[i].getSalary() == max_salary) 
				System.out.println(staffs[i].toString());
		}
	}
}
