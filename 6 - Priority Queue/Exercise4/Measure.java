package PriorityQueue.Exercise4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import PriorityQueue.Exercise1.Entry;
import PriorityQueue.Exercise1.PriorityQueueInterface;
import PriorityQueue.Exercise1.SortedArrayPriorityQueue;
import PriorityQueue.Exercise1.SortedLinkedPriorityQueue;
import PriorityQueue.Exercise1.UnsortedArrayPriorityQueue;
import PriorityQueue.Exercise1.UnsortedLinkedPriorityQueue;

public class Measure {
	
	
	public static PriorityQueueInterface<Integer, Integer> getClass(int sign, int length) {
		PriorityQueueInterface<Integer,Integer> priorityQ;
		
		if (sign == 0) {
			if (length > 1000) priorityQ = new UnsortedArrayPriorityQueue<Integer, Integer>(length + 1);
			else priorityQ = new UnsortedArrayPriorityQueue<Integer, Integer>(); 
		} else if (sign == 1) {
			if (length > 1000) priorityQ = new SortedArrayPriorityQueue<Integer, Integer>(length + 1);
			else priorityQ = new SortedArrayPriorityQueue<Integer, Integer>(); 
		} 
		else if (sign == 2) priorityQ = new UnsortedLinkedPriorityQueue<>();
		else if (sign == 3) priorityQ = new SortedLinkedPriorityQueue<>(); 
		else throw new IllegalArgumentException("Not valid!");
		
		return priorityQ;
	}

	public static void judge(int sign, int length) {
		PriorityQueueInterface<Integer, Integer> priorityQ = getClass(sign, length);
		
		long startInsert = System.currentTimeMillis();
		for (int i=0; i<length; i++) priorityQ.insert(i, i);
		insert.get(sign).add(System.currentTimeMillis() - startInsert);
		
		long startRemove = System.currentTimeMillis();
		for (int i=0; i<length; i++) priorityQ.removeMin();
		removeMin.get(sign).add(System.currentTimeMillis() - startRemove);
		
	}
	
	static ArrayList<ArrayList<Long>> insert = new ArrayList<>();
	static ArrayList<ArrayList<Long>> removeMin = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Long> UnsortedArrayInsert = new ArrayList<>();
		ArrayList<Long> SortedArrayInsert = new ArrayList<>();
		ArrayList<Long> UnsortedLinkedInsert = new ArrayList<>();
		ArrayList<Long> SortedLinkedInsert = new ArrayList<>();
		
		ArrayList<Long> UnsortedArrayRemoveMin = new ArrayList<>();
		ArrayList<Long> SortedArrayRemoveMin = new ArrayList<>();
		ArrayList<Long> UnsortedLinkedRemoveMin = new ArrayList<>();
		ArrayList<Long> SortedLinkedRemoveMin = new ArrayList<>();
		
		insert.add(UnsortedArrayInsert);
		insert.add(SortedArrayInsert);
		insert.add(UnsortedLinkedInsert);
		insert.add(SortedLinkedInsert);
		
		removeMin.add(UnsortedArrayRemoveMin);
		removeMin.add(SortedArrayRemoveMin);
		removeMin.add(UnsortedLinkedRemoveMin);
		removeMin.add(SortedLinkedRemoveMin);
		
		int numAlgo = 4;
//		int[] sizes = {(int) 1e3, (int) 1e4, (int) 1e5, (int) 1e6, (int) 1e7, (int) 1e8};
		int[] sizes = {(int) 10000};
		
		for (int size: sizes) {
			for (int i=0; i<numAlgo; i++) {
			judge(i, size);
			}
		}	
		
		String fileName = "src/PriorityQueue/Exercise4/results.txt";
		FileWriter objectFile = new FileWriter(fileName);
		objectFile.write("\nINSERT() METHOD\n");
		for (int i=0; i<insert.size(); i++) {
			objectFile.write(insert.get(i).toString() + "\n");
		}
		
		objectFile.write("\nREMOVEMIN() METHOD\n");
		for (int i=0; i<removeMin.size(); i++) {
			objectFile.write(removeMin.get(i).toString() + "\n");
		}
		objectFile.close();
		
	}

}
