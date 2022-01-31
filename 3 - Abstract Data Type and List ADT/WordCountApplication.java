package AbstractDataTypeandListADT;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class WordCountApplication {
	
	// Create WordCount object
	static class WordCount {
		String word;
		int count;
		
		public WordCount(String word, int count) { 
			this.word = word;
			this.count = count;
		}
		
		public String toString() {
			return word + " - " + count + "\n";
		}
	}

	public static void main(String[] args) {
		// Read file to take matrix list with all words
		String file_name = "big.txt";
		// Initialize with large capacity to make sure there is enough space to save the words
		int CAPACITY = 5000;   
		
		SimpleArrayList<String> wordList = null;
		
		try {
			wordList = readFile(file_name, CAPACITY);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Create "foundWord" corresponds to "word" in "wordDict". When adding one element
		SimpleArrayList<WordCount> wordDict = new SimpleArrayList<>(CAPACITY);
		SimpleArrayList<String> foundWord = new SimpleArrayList<String>(CAPACITY);
		
		// Loop through all words in word list
		for (String word: wordList) {
			// If the word is out of "wordDict", the word is out of "foundWord"
			if (!foundWord.isContain(word)) {
				// Create new element that do not appear in "wordDict", so element.count = 1
				WordCount new_element = new WordCount(word, 1);
				// Add element
				wordDict.add(new_element);
				// Because "foundWord" map to "word" in "wordDict". Therefore, 
				// "wordDict" is added one element, so did it
				foundWord.add(word);
			} else {   // If word is in wordDict
				// Find position of word in "wordDict" from "foundWord" (due "foundWord" map to "word" in "wordDict")
				int index = foundWord.indexOf(word);
				WordCount element = wordDict.get(index);
				// Increment count to 1
				element.count += 1;
			}
		}
		
		// Print out 
		System.out.println(wordDict.toString());
		
		/* UNCOMMENT IF YOU GET ERROR WITH PATH
		 * String dir = System.getProperty("user.dir"); 
		 * System.out.println(dir);
		 */
	}
	
	
	/*
	 * Args: 
	 * 		file_name: name of file that need to read 
	 * 		capacity: space for saving words
	 * Returns: 
	 * 		wordList: matrix list that containing all words from "lines"
	 */
	public static SimpleArrayList<String> readFile(String file_name, int capacity) throws IOException {
		// Create array list to save words
		SimpleArrayList<String> wordList = new SimpleArrayList<String>(capacity);
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(file_name));
			String line;
			while ((line = reader.readLine()) != null) {
				String regex = "([^matrix-zA-Z']+)'*\\1*";     // Define non-word using regular expression
				String[] split = line.split(regex);
				for (int i=0; i<split.length; i++) {
					wordList.add(split[i].toLowerCase());    // Example: "she" and "SHE" is the same
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return wordList;
	}
	

}
