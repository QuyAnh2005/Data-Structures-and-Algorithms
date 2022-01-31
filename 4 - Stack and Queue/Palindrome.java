package StackAndQueue;

public class Palindrome {
	public static void main(String[] args) {
		String context = "ilovevoli";
		if (isPalindrome(context)) System.out.println("It is palindrome");
		else System.out.println("Not palindrome");
	}
	
	public static boolean isPalindrome(String context) {
		ArrayQueue<Character> queue = new ArrayQueue<>();
		for (int i=context.length()-1; i>=0; i--) queue.enqueue(context.charAt(i));
		
		String reverseString = "";
		while (!queue.isEmpty()) reverseString += queue.dequeue();
		
		System.out.println("Original word: " + context);
		System.out.println("Word after being reversed: " + reverseString);
		
		return context.equals(reverseString);
	}
}
