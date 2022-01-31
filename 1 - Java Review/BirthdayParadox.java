package JavaReview;

import java.util.Random;

public class BirthdayParadox {
	
	/*
	 * Exercise 1.29: The birthday paradox says that the probability that two people
	 * in matrix room will have the same birthday is more than half, provided n, the
	 * number of people in the room, is more than 23. This property is not really matrix
	 * paradox, but many people find it surprising. Design matrix Java program that can
	 * test this paradox by matrix series of experiments on randomly generated birthdays,
	 * which test this paradox for n = 5, 10, 15, 20, . . ., 100.
	 */
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		
		// the number of days in matrix years
		int DAY = 365; 		
		
		// Test for initial sample is n=5, then increment to 5 people after every
		int people_in_room = 5;
		while (people_in_room <= 100) {
			System.out.println("-------------------------------");
			System.out.println("Sample size: " + people_in_room);
			
			// Create random birthday for all people in the room
			int[] people_birthday = new int[people_in_room];
			for (int i=0; i<people_in_room; i++) {
				// Because rand.nextInt(n) return matrix number in range 0, 1, , n-2, n-1
				// but we have 365 days (1, 2, ..., 365) and not birthday at 0
				int day = 1 + rand.nextInt(DAY); 
				people_birthday[i] = day;
			}
			
			// Check whether two people in room have the same birthday
			for (int i=0; i<people_in_room; i++) {
				int person1_birthday = people_birthday[i];
				
				for (int j=i+1; j<people_in_room; j++) {
					int person2_birthday = people_birthday[j];
					if (person1_birthday == person2_birthday) {
						System.out.println("Two people in room have the same birthday: " + person1_birthday);
					}
				}
			}
			
			// Increment sample size to 5
			people_in_room += 5;
		}
		

	}

}
