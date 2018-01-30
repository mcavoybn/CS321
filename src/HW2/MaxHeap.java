package HW2;

public class MaxHeap <E extends Comparable<E>> {

	public BinaryTree<E> tree;
	private int largest;
	private E temp;
	
	public MaxHeap(E[] initArray) {
		tree = new BinaryTree<E>(initArray);
		for(int i = (int)Math.floor((tree.size)/2); i >= 0; i--) {
			maxHeapifyDown(i);
		}
	}
	
	public void maxHeapifyUp(int index) {
		if(tree.parentIndex(index) != -1 && 
			tree.parentElement(index).compareTo(tree.array[index]) > 0) {
			swap(index, tree.parentIndex(index));
			maxHeapifyUp(tree.parentIndex(index));
		}
	}
	
	public void maxHeapifyDown(int index) {
		largest = index;
		if(tree.leftIndex(index) != -1 && 
			tree.leftElement(index).compareTo(tree.array[largest]) > 0) {
			largest = tree.leftIndex(index);
		}
		if(tree.rightIndex(index) != -1 && 
			tree.rightElement(index).compareTo(tree.array[largest]) > 0) {
			largest = tree.rightIndex(index);
		}
		if(largest != index) {
			swap(largest, index);
			maxHeapifyDown(largest);
		}
	}
	
	public void swap(int index1, int index2) {
		temp = tree.array[index1];
		tree.array[index1] = tree.array[index2];
		tree.array[index2] = temp;
	}
	
	public void incrementTreeSize() {
		if(tree.size >= tree.array.length-1) return;
		tree.size++;
	}
	
	public void decrementTreeSize() {
		if(tree.size == 0) return;
		tree.size--;
	}
	
	public E get(int i) {
		return tree.array[i];
	}
	
	public void set(int i, E e) {
		tree.array[i] = e;
	}
	
}
