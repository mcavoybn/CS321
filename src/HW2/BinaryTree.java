package HW2;

public class BinaryTree <E extends Comparable<E>> {
	
	public E[] array;
	
	public BinaryTree(E[] initArray){
		array = initArray;
	}
	
	public int leftIndex(int index) {
		int i = 2*index + 1;
		if(i < array.length) return i;
		else return -1;
	}
	
	public int rightIndex(int index) {
		int i = 2*index + 2;
		if(i < array.length) return i;
		else return -1;
	}
	
	public int parentIndex(int index) {
		int i = (int)Math.floor(index/2) + 1;
		if(i < array.length) return i;
		else return -1;
	}
	
	public E leftElement(int index) {
		int i = 2*index+1;
		if(i < array.length) return array[i];
		else return null;
	}
	
	public E rightElement(int index) {
		int i = 2*index+2;
		if(i < array.length) return array[i];
		else return null;
	}
	
	public E parentElement(int index) {
		int i = (int)Math.floor(index/2) + 1;
		if(i < array.length) return array[i];
		else return null;
	}
	
}
