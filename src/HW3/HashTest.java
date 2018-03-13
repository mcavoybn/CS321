package HW3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class HashTest {
	
	public static void main(String args[]) throws FileNotFoundException {
		
		int totalInputs;
		int totalDuplicates;
		double userLoadFactor = Double.valueOf(args[1]);
		if(args[0].equals("1")) {
			System.out.println("Data source type: Integer");	
			Random rand = new Random();
			int randInt = -1;			
					
			System.out.println("Using Linear Hashing...");
			HashTable<Integer> ht = new HashTable<Integer>(95087, 0);			
			totalInputs = 0; totalDuplicates = 0;
			while(ht.loadFactor < userLoadFactor) {
				randInt = Math.abs(rand.nextInt());
				if(ht.insert(randInt)) totalInputs++;
				else totalDuplicates++;
			}
			printData(totalInputs, totalDuplicates, userLoadFactor, ht.probeCount);
			
			
			System.out.println("Using Double Hashing...");
			ht = new HashTable<Integer>(95087, 1);
			totalInputs = 0; totalDuplicates = 0;
			while(ht.loadFactor < userLoadFactor) {
				randInt = Math.abs(rand.nextInt());
				if(ht.insert(randInt)) totalInputs++;
				else totalDuplicates++;
			}
			printData(totalInputs, totalDuplicates, userLoadFactor, ht.probeCount);
			if(args[2] != null && args[2].equals("1")) printTable(ht);
		}
		
		if(args[0].equals("2")) {
			System.out.println("Data source type: Long");		
					
			System.out.println("Using Linear Hashing...");
			HashTable<Long> ht = new HashTable<Long>(95087, 0);			
			totalInputs = 0; totalDuplicates = 0;
			long t = 0L;
			while(ht.loadFactor < userLoadFactor) {
				t = System.currentTimeMillis();
				if(ht.insert(t)) totalInputs++;
				else totalDuplicates++;
			}
			printData(totalInputs, totalDuplicates, userLoadFactor, ht.probeCount);
			
			
			System.out.println("Using Double Hashing...");
			ht = new HashTable<Long>(95087, 1);
			totalInputs = 0; totalDuplicates = 0;
			while(ht.loadFactor < userLoadFactor) {
				t = System.currentTimeMillis();
				if(ht.insert(t)) totalInputs++;
				else totalDuplicates++;
			}
			printData(totalInputs, totalDuplicates, userLoadFactor, ht.probeCount);
			if(args[2] != null && args[2].equals("1")) printTable(ht);
		}
		if(args[0].equals("3")) {
			System.out.println("Data source type: String");
			Scanner s = new Scanner(new File(System.getProperty("user.dir") + "/src/HW3/word-list"));	
			
			System.out.println("Using Linear Hashing...");
			HashTable<String> ht = new HashTable<String>(95087, 0);			
			totalInputs = 0; totalDuplicates = 0;
			String word;
			while(ht.loadFactor < userLoadFactor) {
				word = s.next();
				if(ht.insert(word)) totalInputs++;
				else totalDuplicates++;
			}
			printData(totalInputs, totalDuplicates, userLoadFactor, ht.probeCount);
			
			
			System.out.println("Using Double Hashing...");
			s = new Scanner(new File(System.getProperty("user.dir") + "/src/HW3/word-list"));	
			ht = new HashTable<String>(95087, 1);
			totalInputs = 0; totalDuplicates = 0;
			while(ht.loadFactor < userLoadFactor) {
				word = s.next();
				if(ht.insert(word)) totalInputs++;
				else totalDuplicates++;
			}
			printData(totalInputs, totalDuplicates, userLoadFactor, ht.probeCount);
			if(args[2] != null && args[2].equals("1")) printTable(ht);
		}
	}	

	
	static void printTable(HashTable ht) {
		for(int i=0; i < ht.table.length; i++) {
			if(ht.table[i] != null) {
				System.out.println("table[" + i + "]:  " + ht.table[i].toString() + " " + ht.table[i].frequencyCount);
			}	
		}
	}
	
	static void printData(int totalInputs, int totalDuplicates, double loadFactor, int probeCount) {
		System.out.println("Input " + totalInputs + " elements, of which " + totalDuplicates + " duplicates");
		System.out.println("load factor =  " + loadFactor + ", Avg. no. of probes = " + (probeCount / 95087.0));
	}

}
