package HW2;

public class MaxHeap <E extends Comparable<E>> {

	public BinaryTree<E> tree;
	private E temp;
	
	public MaxHeap(E[] initArray) {
		tree = new BinaryTree<E>(initArray);
		for(int i = tree.array.length-1; i >= 0; i--) {
			if(tree.rightIndex(i) != -1 &&
				tree.rightElement(i).compareTo(tree.array[i]) > 0) {
				swapValues(tree.array, tree.rightIndex(i), tree.parentIndex(i));
				maxHeapify(tree.rightIndex(i));
			}
			if(tree.leftIndex(i) != -1 && 
				tree.leftElement(i).compareTo(tree.array[i]) > 0) {
				swapValues(tree.array, tree.leftIndex(i), tree.parentIndex(i));
				maxHeapify(tree.leftIndex(i));
			}
			if(tree.rightIndex(i) != -1 &&
					tree.rightElement(i).compareTo(tree.array[i]) > 0) {
					swapValues(tree.array, tree.rightIndex(i), tree.parentIndex(i));
					maxHeapify(tree.rightIndex(i));
				}
		}
	}
	
	public void maxHeapify(int index) {
		if(tree.leftIndex(index) != -1 && 
			tree.leftElement(index).compareTo(tree.array[i]) > 0) {
			swapValues(tree.array, tree.leftIndex(index), tree.parentIndex(index));
			maxHeapify(tree.leftIndex(index));
		}
	}
	
	public void swapValues(E[] arr, int index1, int index2) {
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
}
