package HW1;

import java.util.LinkedList;

public class Cache <E> {
	
	private int l1maxSize;
	private int l2maxSize;	
	public boolean l2enabled;
	public int l1HitCount;
	public int l2HitCount;
	public int l1RefCount;
	public int l2RefCount;	
	private LinkedList<E> l1;
	private LinkedList<E> l2;
	
	public Cache(int l1size, int l2size, boolean l2enable) {
		l1maxSize = l1size;
		l2maxSize = l2size;
		l2enabled = l2enable;
		l1HitCount = 0;
		l2HitCount = 0;
		l1RefCount = 0;
		l2RefCount = 0;
		l1 = new LinkedList<E>();
		if(l2enabled) l2 = new LinkedList<E>();
	}

	public void addObject(E object) {
		l1.addFirst(object);
		if(l1.size() >= l1maxSize) l1.removeLast();
		if(l2enabled) {
			l2.addFirst(object);
			if(l2.size() >= l2maxSize) l2.removeLast();
		}
	}

	public E getObject(E object) {
		removeObject(object);
		addObject(object);
		return (E)l1.get(0);
	}

	public void removeObject(E object) {
		l1RefCount++;
		if(l1.indexOf(object) != -1) {
			l1HitCount++;
			l1.remove(l1.indexOf(object));
			if(l2enabled) l2.remove(l2.indexOf(object));
		}else if(l2enabled) {
			l2RefCount++;
			if(l2.indexOf(object) != -1) {
				l2HitCount++;
				l2.remove(l2.indexOf(object));
			}
		}
	}
	
	public void clearCache(E object){
		l1.clear();
		if(l2enabled) l2.clear();
	}
	
}
