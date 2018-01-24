package HW1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args){
		if(args[0].equals("1")) {
			Cache<String> cache = new Cache<String>( Integer.parseInt(args[1]), 0, false);
			System.out.println("First level cache with " + args[1] + " entries has been created");
			System.out.println("Running file " + args[2] + " through cache");
			File f = new File(System.getProperty("user.dir") + "/src/HW1/" + args[2]);					
			getCacheStats(cache, f);
		}
		if(args[0].equals("2")) {
			Cache<String> cache = new Cache<String>( Integer.parseInt(args[1]), Integer.parseInt(args[2]), true);
			System.out.println("First level cache with " + args[1] + " entries has been created");
			System.out.println("Second level cache with " + args[2] + " entries has been created");
			System.out.println("Running file " + args[3] + " through cache");
			File f = new File(System.getProperty("user.dir") + "/src/HW1/" + args[3]);	
			getCacheStats(cache, f);
		}			
	}	
	
	public static void getCacheStats(Cache<String> cache, File file) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			String[] lineWords;
			while( (line = reader.readLine()) != null) {
				lineWords = line.split("([ ])");
				for(String word : lineWords) 
					cache.getObject(word);
			}
			reader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		int totalReferences = cache.l1RefCount + cache.l2RefCount;
		int totalHits = cache.l1HitCount + cache.l2HitCount;
		double globalHitRatio = ((double)totalHits / (double)cache.l1RefCount);
		double l1HitRatio = ((double)cache.l1HitCount / (double)cache.l1RefCount);
		
		System.out.println("Total number of references: " +  totalReferences);
		System.out.println("Total number of cache hits: " + totalHits);
		System.out.println("The global hit ratio: " + globalHitRatio);
		System.out.println("Number of 1st-level cache hits: " + cache.l1RefCount);
		System.out.println("1st level cache hit ratio: " + l1HitRatio);
		if(cache.l2enabled) {
			double l2HitRatio = ((double)cache.l2HitCount / (double)cache.l2RefCount);
			System.out.println("Number of 2nd-level cache hits: " + cache.l2RefCount);
			System.out.println("2nd level cache hit ratio: " + l2HitRatio);
		}
		
	}
}
