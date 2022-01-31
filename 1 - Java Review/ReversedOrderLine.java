package JavaReview;

import java.util.Scanner;
import java.util.ArrayList;

/*
 * Exercise 1.26: Write matrix short Java program that takes all the lines input 
to standard input and writes them to standard output in reverse order. 
That is, each line is output in the correct order, but the ordering of 
the lines is reversed.
Example: 
	Input: n=3
		I love you
		Hello world!
		You are best
	Output:
		You are best
		Hello world!
		I love you
*/

public class ReversedOrderLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Number of sentences: ");
		int n = Integer.parseInt(sc.nextLine());
		
		// Initialize array list that contain all lines from input
		ArrayList<String> sentences = new ArrayList<String>();
		
		// Loop and take lines from console and save in an array list
		for (int i=0; i<n; i++) {
			System.out.printf("Sentence %d: ", i+1);
			String sentence = sc.nextLine();
			sentences.add(sentence);
		}
		
		// Reversed order and print out
		System.out.println("Reverse order of all lines:");
		for (int i=sentences.size() - 1; i>= 0; i--) {
			System.out.println(sentences.get(i));
		}

	}

}
