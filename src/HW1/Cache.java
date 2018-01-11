package HW1;

import java.util.LinkedList;
public class Cache {
	
	int hitCount;
	int refCount;
	int curSize;
	int maxSize;
	
	public <E> Cache(int numLevels, int maxSize) {
		curSize = 0;
		hitCount = 0;
		refCount = 0;
		maxSize = this.maxSize;
		LinkedList<E> l1 = new LinkedList<E>();
		LinkedList<E> l2 = new LinkedList<E>();
	}
	
	public <E> void addObject(E object) {
		hitCount++;
	}

	public <E> void getObject(E object) {
		hitCount++;
	}

	public <E> void removeObject(E object) {
		hitCount++;
	}
	
	public <E> void clearCache(E object){
		hitCount++;
	}

}

