package HW1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args){
		if(args[0].equals("1")) {
			Cache cache = new Cache( Integer.parseInt(args[1]), 0, false);
			System.out.println("First level cache with " + args[1] + " entries has been created");
			File f = new File("./" + args[2]); //this needs to be fixed		
			getCacheStats(cache, f);
		}
		if(args[0].equals("2")) {
			Cache cache = new Cache( Integer.parseInt(args[1]), Integer.parseInt(args[2]), true);
			System.out.println("First level cache with " + args[1] + " entries has been created");
			System.out.println("Second level cache with " + args[2] + " entries has been created");
			File f = new File(System.getProperty("user.dir") + args[3]); //this needs to be fixed		
			getCacheStats(cache, f);
		}			
	}	
	
	public static void getCacheStats(Cache c, File f) {
		Scanner in;
		try {
			in = new Scanner(f);
			System.out.println("Running file Encyclopedia.txt through cache");
			int counter = 0;
			while(in.hasNext()) {
				c.getObject(in.next());
				counter++;
				if(counter%10000==0 && counter<10000000) System.out.print('.');
			}
			System.out.println(' ');
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		int totalReferences = c.l1RefCount + c.l2RefCount;
		int totalHits = c.l1HitCount + c.l2HitCount;
		double globalHitRatio = ((double)totalHits/(double)c.l1RefCount);
		double l1HitRatio = ((double)c.l1HitCount/(double)c.l1RefCount);
		System.out.println("Total number of references: " +  totalReferences);
		System.out.println("Total number of cache hits: " + totalHits);
		if(c.l2enabled) System.out.println("The global hit ratio: " + globalHitRatio);
		System.out.println("Number of 1st-level cache hits: " + c.l1RefCount);
		System.out.println("1st level cache hit ratio: " + l1HitRatio);
		if(c.l2enabled) {
			double l2HitRatio = ((double)c.l2HitCount/(double)c.l2RefCount);
			System.out.println("Number of 2nd-level cache hits: " + c.l2RefCount);
			System.out.println("2nd level cache hit ratio: " + l2HitRatio);
		}
		
	}
}
