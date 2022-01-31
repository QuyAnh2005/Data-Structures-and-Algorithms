package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// BAI 6
enum Suit {
	SPADE, CLUB, DIAMOND, HEART
}
public class Card implements Comparable<Card> {
	
	private int rank;
	private Suit suit;
	
	public Card(int r, Suit s) {
		rank = r;
		suit = s;
	}
	
	public int getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public String rankToString(int rank) {
		switch (rank) {
		case 1: return "A";
		case 2: return "2";
		case 3: return "3";
		case 4: return "4";
		case 5: return "5";
		case 6: return "6";
		case 7: return "7";
		case 8: return "8";
		case 9: return "9";
		case 10: return "10";
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		default: return "Invalid card";
	}
}
	public String toString() {
		return rankToString(rank) + "­ " + suit;
	}
	
	public void showCard() {
		System.out.println(toString());
	}
		
	public int getIndex() {
		switch (this.suit) {
		case SPADE: return 0;
		case CLUB: return 1;
		case DIAMOND: return 2;
		case HEART: return 3;
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.suit);
		}
	}
	@Override
	public int compareTo(Card otherCard) {
		if (this.getRank()>otherCard.getRank())
			return 1;
		else if(this.getRank()<otherCard.getRank())
			return -1;
		else {
			if (this.getIndex()>otherCard.getIndex())
				return 1;
			if (this.getIndex()<otherCard.getIndex())
				return -1;
		}
		return 0;
	
	}
	
	// Generate 52 cards in deck
	public static Card[] generate() {
		Card[] cards = new Card[52];
		int index = 0;
		for(int i=1;i<14;i++) { 
			for(Suit suit: Suit.values()) {
				Card card = new Card(i, suit);
				cards[index] = card;
				index += 1;
			}
		}
		return cards;
	}
	
	// Function for printing elements of array
	public static void printOut(Card[] cards) {
		for (int i=0; i<cards.length; i++) {
			System.out.print(cards[i].toString() + ", ");
		}
		System.out.println();
	}
	
	// Function for shuffling cards
	public static Card[] shuffle(Card[] cards) {
		System.out.println("Shuffle your cards:");
		Random rand = new Random();
		int length = cards.length;
		for (int i=0; i<length; i++) {
			int randInt = rand.nextInt(length);
			// Swap random two element in array
			Card temp = cards[i];
			cards[i] = cards[randInt];
			cards[randInt] = temp;
		}
		return cards;
	}
	
	public static void main(String args[]) {
		
		// Generate deck and print
		Card[] cards = generate();
		System.out.println("Generate deck: ");
		printOut(cards);
		
		// shuffle cards and print
		shuffle(cards);
		printOut(cards);
		
		// SORTING CARD USING COMPARATOR
		System.out.println("\n\nSort cards using Comparator:");
		Arrays.sort(cards, new comparecard());
		printOut(cards);
		
		/* SORTING CARDS USING METHOD IN EXERCISE 5 (COMPARABLE) */
		System.out.println("\n\nUSING METHOD IN EXERCISE 5");
		GenericSort<Card> sort = new GenericSort<>(cards);
		
		// Bubble sort
		shuffle(cards);
		printOut(cards);
		System.out.println("BUBBLE SORT");
		sort.bubbleSort();
		System.out.println(sort.seeEffection());
		
		// Selection sort
		shuffle(cards);
		printOut(cards);
		System.out.println("SELECTION SORT");
		sort.selectionSort();
		System.out.println(sort.seeEffection());
		
		// Insertion sort
		shuffle(cards);
		printOut(cards);
		System.out.println("INSERTION SORT");
		sort.insertionSort();
		System.out.println(sort.seeEffection());
		
	}
	
}
	
