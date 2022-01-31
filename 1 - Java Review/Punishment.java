package JavaReview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class Punishment {
	
	/*
	 * Exercise 1.28: A common punishment for school children is to write out matrix
	 * sentence multiple times. Write matrix Java stand-alone program that will write out
	 * the following sentence one hundred times: “I will never spam my friends
	 * again.” Your program should number each of the sentences and it should make
	 * eight different random-looking typos.
	 */

	public static void main(String[] args) {
		
		// Your sentence
		String sentence = "I will never spam my friends again.";		
		int N = 100; 	// Because we must write out above sentence 100 times 
		
		// generate 8 unique typo indexes
		Set<Integer> typoIndexes = new HashSet<>();
		while (typoIndexes.size() < 8) {
			int index = (int) (Math.random() * 100);
		    typoIndexes.add(index);
		}
		
		// make n-mistake typos from sentence
		int NUMBER_MISTAKE = 8;
		String[] typos = makeTypos(NUMBER_MISTAKE, sentence);
		
		// Initialize count_typos from 0 to 7, for taking count_typos-th elements of typos
		int count_typos = 0;
		for (int i=0; i<N; i++) {
			if (typoIndexes.contains(i)) {
				System.out.println(typos[count_typos]);
				// Increment 1 if i in typoIndexes
				count_typos += 1;
			}
			else {
				System.out.println(sentence);
			}
		}
	}
	
	
	// Function for make n different random-looking typos with given sentence
	public static String[] makeTypos(int n, String sentence) {
		// Use set to make sure that every typos is not same
		Set<String> typos = new HashSet<>();
		while (typos.size() < n) {
			StringBuilder sb = new StringBuilder(sentence);
			
			Random rand = new Random();
			int randint = rand.nextInt(sb.length());
			sb.setCharAt(randint, ' '); 	// Remove n-th element of sentence
			typos.add(sb.toString());
		}
		// When use set, you can't reach element by index, you should convert to array 
		String[] typosList = typos.toArray(new String[n]);
		return typosList;
	}

}
