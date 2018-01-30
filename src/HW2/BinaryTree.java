package HW2;

public class BinaryTree <E extends Comparable<E>> {
	
	public E[] array;
	public int size;
	public int i;
	
	public BinaryTree(E[] initArray){
		size = 0;
		array = initArray;
	}
	
	public E leftElement(int index) {
		i = 2*index+1;
		if(i < size) return array[i];
		else return null;
	}
	
	public int leftIndex(int index) {
		i = 2*index + 1;
		if(i < size) return i;
		else return -1;
	}
	
	public E parentElement(int index) {
		if(index == 0) return null;
		i = (int)Math.floor(index/2) + 1;
		if(i < size) return array[i];
		else return null;
	}
	
	public int parentIndex(int index) {
		if(index == 0) return -1;
		i = (int)Math.floor(index/2) + 1;
		if(i < size) return i;
		else return -1;
	}
	
	public int rightIndex(int index) {
		i = 2*index + 2;
		if(i < size) return i;
		else return -1;
	}
	
	public E rightElement(int index) {
		i = 2*index + 2;
		if(i < size) return array[i];
		else return null;
	}	
}
