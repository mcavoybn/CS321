package HW2;

public class MaxHeap <E extends Comparable<E>> {

	public BinaryTree<E> tree;
	
	public MaxHeap() {
		tree = new BinaryTree<E>();
	}
	
	public void add(E element) {
		tree.add(element);
	}
	
	public E get(int i) {
		return tree.get(i);
	}
	
	public void maxHeapifyUp(int index) {
		if(tree.parentIndex(index) != -1 && 
			tree.parentElement(index).compareTo(tree.get(index)) > 0) {
			swap(index, tree.parentIndex(index));
			maxHeapifyUp(tree.parentIndex(index));
		}
	}
	
	public void maxHeapifyDown(int index) {
		int largest = index;
		if(tree.leftIndex(index) != -1 && 
			tree.leftElement(index).compareTo(tree.get(largest)) > 0) {
			largest = tree.leftIndex(index);
		}
		if(tree.rightIndex(index) != -1 && 
			tree.rightElement(index).compareTo(tree.get(largest)) > 0) {
			largest = tree.rightIndex(index);
		}
		if(largest != index) {
			swap(largest, index);
			maxHeapifyDown(largest);
		}
	}
	
	public E remove(int index) {
		return tree.remove(index);
	}
	
	public void set(int index, E element) {
		tree.set(index, element);
	}
	
	public int size() {
		return tree.size();
	}
	
	public void swap(int index1, int index2) {
		E temp = tree.get(index1);
		tree.set(index1,  tree.get(index2));
		tree.set(index2, temp);
	}
	
}
