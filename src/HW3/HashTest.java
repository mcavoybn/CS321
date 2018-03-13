package HW3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class HashTest {
	
	public static void main(String args[]) throws FileNotFoundException {
		
//		int totalInputs;
//		int totalDuplicates;
//		double userLoadFactor = Double.valueOf(args[1]);
//		if(args[0] == "1") {
//			System.out.println("Data source type: Integer");	
//			Random rand = new Random();
//			int randInt = -1;			
//					
//			System.out.println("Using Linear Hashing...");
//			HashTable<Integer> ht = new HashTable<Integer>(95087, 0);			
//			totalInputs = 0; totalDuplicates = 0;
//			while(ht.loadFactor < userLoadFactor) {
//				randInt = Math.abs(rand.nextInt());
//				if(ht.insert(randInt)) totalInputs++;
//				else totalDuplicates++;
//			}
//			printData(totalInputs, totalDuplicates, userLoadFactor, ht.probeCount);
//			
//			
//			System.out.println("Using Double Hashing...");
//			ht = new HashTable<Integer>(95087, 1);
//			totalInputs = 0; totalDuplicates = 0;
//			while(ht.loadFactor < userLoadFactor) {
//				randInt = Math.abs(rand.nextInt());
//				if(ht.insert(randInt)) totalInputs++;
//				else totalDuplicates++;
//			}
//			printData(totalInputs, totalDuplicates, userLoadFactor, ht.probeCount);
//			if(args[2] != null && args[2] == "1") printTable(ht);
//		}
//		
//		if(args[0] == "2") {
//			System.out.println("Data source type: Long");		
//					
//			System.out.println("Using Linear Hashing...");
//			HashTable<Long> ht = new HashTable<Long>(95087, 0);			
//			totalInputs = 0; totalDuplicates = 0;
//			long t = 0L;
//			while(ht.loadFactor < userLoadFactor) {
//				t = System.currentTimeMillis();
//				if(ht.insert(t)) totalInputs++;
//				else totalDuplicates++;
//			}
//			printData(totalInputs, totalDuplicates, userLoadFactor, ht.probeCount);
//			
//			
//			System.out.println("Using Double Hashing...");
//			ht = new HashTable<Long>(95087, 1);
//			totalInputs = 0; totalDuplicates = 0;
//			while(ht.loadFactor < userLoadFactor) {
//				t = System.currentTimeMillis();
//				if(ht.insert(t)) totalInputs++;
//				else totalDuplicates++;
//			}
//			printData(totalInputs, totalDuplicates, userLoadFactor, ht.probeCount);
//			if(args[2] != null && args[2] == "1") printTable(ht);
//		}
//		if(args[0] == "3") {
//			System.out.println("Data source type: String");
//			Scanner s = new Scanner(new File(System.getProperty("user.dir") + "/src/HW3/word-list"));	
//			
//			System.out.println("Using Linear Hashing...");
//			HashTable<String> ht = new HashTable<String>(95087, 0);			
//			totalInputs = 0; totalDuplicates = 0;
//			String word;
//			while(ht.loadFactor < userLoadFactor) {
//				word = s.next();
//				if(ht.insert(word)) totalInputs++;
//				else totalDuplicates++;
//			}
//			printData(totalInputs, totalDuplicates, userLoadFactor, ht.probeCount);
//			
//			
//			System.out.println("Using Double Hashing...");
//			s = new Scanner(new File(System.getProperty("user.dir") + "/src/HW3/word-list"));	
//			ht = new HashTable<String>(95087, 1);
//			totalInputs = 0; totalDuplicates = 0;
//			while(ht.loadFactor < userLoadFactor) {
//				word = s.next();
//				if(ht.insert(word)) totalInputs++;
//				else totalDuplicates++;
//			}
//			printData(totalInputs, totalDuplicates, userLoadFactor, ht.probeCount);
//			if(args[2] != null && args[2] == "1") printTable(ht);
//		}
		
		
		double[] loadFactors = { 0.5, 0.6, 0.7, 0.8, 0.9, 0.95, 0.98, 0.99 };		
		double linearProbeCount = -1;
		double doubleProbeCount = -1;
		
		System.out.println("Input Source 1: random number");
		System.out.println("alpha linear double");
		System.out.println("---------------------------");
		
		for(double loadFactor : loadFactors) {
			Random rand = new Random();
			int randInt = -1;
			HashTable<Integer> ht = new HashTable<Integer>(95087, 0);
			while(ht.loadFactor < loadFactor) {
				randInt = Math.abs(rand.nextInt());
				ht.insert(randInt);
			}
			linearProbeCount = (double)ht.probeCount / 95087.0;
			
			ht = new HashTable<Integer>(96197, 1);
			while(ht.loadFactor < loadFactor) {
				randInt = Math.abs(rand.nextInt());
				ht.insert(randInt);
			}
			doubleProbeCount = (double)ht.probeCount / 95087.0;
			
			System.out.println(loadFactor + " " + linearProbeCount + " " + doubleProbeCount);
		}		
		
		
		System.out.println("\n\nInput Source 2: current time");
		System.out.println("alpha linear double");
		System.out.println("---------------------------");
		
		for(double loadFactor : loadFactors) {
			HashTable<Long> ht = new HashTable<Long>(95087, 0);
			long t = System.currentTimeMillis();
			while(ht.loadFactor < loadFactor) {
				ht.insert(t);
				t++;				
			}
			linearProbeCount = ht.probeCount / 95087.0;
			
			ht = new HashTable<Long>(96197, 1);
			t = System.currentTimeMillis();
			while(ht.loadFactor < loadFactor) {
				if(t != System.currentTimeMillis()) {
					ht.insert(t);
					t++;
				}
			}
			doubleProbeCount = ht.probeCount / 95087.0;
			
			System.out.println(loadFactor + " " + linearProbeCount + " " + doubleProbeCount);
		}
		
		System.out.println("\n\nInput Source 3: word-list");
		System.out.println("alpha linear double");
		System.out.println("---------------------------");
		for(double loadFactor : loadFactors) {
			Scanner s = new Scanner(new File(System.getProperty("user.dir") + "/src/HW3/word-list"));
			HashTable<String> ht = new HashTable<String>(95087, 0);
			while(ht.loadFactor < loadFactor) {
				ht.insert(s.next());
			}
			linearProbeCount = ht.probeCount / 95087.0;
			
			s = new Scanner(new File(System.getProperty("user.dir") + "/src/HW3/word-list"));
			ht = new HashTable<String>(96197, 1);
			while(ht.loadFactor < loadFactor) {
				ht.insert(s.next());
			}
			doubleProbeCount = ht.probeCount / 95087.0;
			
			System.out.println(loadFactor + " " + linearProbeCount + " " + doubleProbeCount);
		}
		
	}
	
	static void printTable(HashTable ht) {
		for(int i=0; i < ht.table.length; i++) {
			System.out.println("table[" + i + "]:  " + ht.table[i].toString() + " " + ht.table[i].frequencyCount);
		}
	}
	
	static void printData(int totalInputs, int totalDuplicates, double loadFactor, int probeCount) {
		System.out.println("Input " + totalInputs + " elements, of which " + totalDuplicates + " duplicates");
		System.out.println("load factor =  " + loadFactor + ", Avg. no. of probes = " + (probeCount / 95087.0)  + " duplicates");
	}

}
