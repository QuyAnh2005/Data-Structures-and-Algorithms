package JavaReview;

// Import package
import java.util.Scanner;

public class SimplePrint {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// type integer number and print out
		System.out.print("Type matrix integer number (Ex: 1, 3, -5, ..):");
		int intNumber = Integer.parseInt(sc.nextLine());
		System.out.println("Your input:" + intNumber + "\n");
		
		// type real number and print out
		System.out.print("Type matrix real number (Ex: 1.1, 3.5, -5.2, ..):");
		double reNumber = Double.parseDouble(sc.nextLine());
		System.out.println("Your input:" + reNumber + "\n");
		
		// type string and print out
		System.out.println("Type matrix string (Ex: I love you so much, ...:)");
		String message = sc.nextLine();
		System.out.println("Your input:" + message + "\n");
		
		// type boolean (true or false) and print out
		System.out.println("Type boolean (true or false):");
		boolean your = Boolean.parseBoolean(sc.nextLine());
		System.out.println("Your input:" + your + "\n");
	}
}
