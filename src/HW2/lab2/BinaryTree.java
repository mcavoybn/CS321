import java.util.LinkedList;

public class BinaryTree <E extends Comparable<E>> {
	
	private LinkedList<E> array;
	private int i;	
	
	public BinaryTree(){
		array = new LinkedList<E>();
	}
	
	/////////////////////////////
	
	public void add(E element) {
		array.add(element);
	}
	
	public E get(int index) {
		return array.get(index);
	}	
	
	public E leftElement(int index) {
		i = 2*index+1;
		if(i < array.size()) return array.get(i);
		else return null;
	}
	
	public int leftIndex(int index) {
		i = 2*index + 1;
		if(i < array.size()) return i;
		else return -1;
	}
	
	public E parentElement(int index) {
		if(index == 0) return null;
		i = (int)Math.floor(index/2) + 1;
		if(i < array.size()) return array.get(i);
		else return null;
	}
	
	public int parentIndex(int index) {
		if(index == 0) return -1;
		i = (int)Math.floor(index/2) + 1;
		if(i < array.size()) return i;
		else return -1;
	}
	
	public int rightIndex(int index) {
		i = 2*index + 2;
		if(i < array.size()) return i;
		else return -1;
	}
	
	public E rightElement(int index) {
		i = 2*index + 2;
		if(i < array.size()) return array.get(i);
		else return null;
	}	
	
	public E remove(int index) {
		return array.remove(index);
	}
	
	public void set(int index, E element) {
		array.set(index, element);
	}
	
	public int size() {
		return array.size();
	}
}
