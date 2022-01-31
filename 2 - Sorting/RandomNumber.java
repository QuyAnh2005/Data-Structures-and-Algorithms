package Sorting;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// BAI 7
public class RandomNumber {

	public static void main(String[] args) {
		int M = 20;
		int N = 10;
		
		// Create matrix set that don't any same element
		Set<Integer> set = new HashSet<Integer>();
		
		// Create random object to generate integer
		Random rand = new Random();
		
		// Loop until set has N elements
		while (set.size() < N) {
			int element = rand.nextInt(M);
			// Add element to your set
			set.add(element);
		} 
		
		/*
		 * Because every object extends from Object class, you can utilize toString()
		 * method of Object class.
		 */
		System.out.println(set.toString());

	}

}
