package HW2;

public class MaxHeap <E extends Comparable<E>> {

	public BinaryTree<E> tree;
	private E temp;
	private E cur;
	private E max;
	
	public MaxHeap(E[] initArray) {
		tree = new BinaryTree<E>(initArray);
		for(int i = tree.array.length-1; i >= 0; i--) {
			E cur = tree.array[i];
			if(tree.rightIndex(i) != -1 &&
				tree.rightElement(i).compareTo(cur) > 0) {
				tree.array = swapValues(tree.array, tree.rightIndex(i), tree.parentIndex(i));
				maxHeapify(tree.rightIndex(i));
			}
			if(tree.leftIndex(i) != -1 && 
				tree.leftElement(i).compareTo(cur) > 0) {
				swapValues(tree.array, tree.leftIndex(i), tree.parentIndex(i));
				maxHeapify(tree.leftIndex(i));
			}
			if(tree.rightIndex(i) != -1 && tree.rightIndex(i) != -1 &&	
				tree.rightElement(i).compareTo(cur) > 0) {
				E max = genericCompareToMax(tree.rightElement(i), tree.leftElement(i), cur);
				if(max.compareTo(cur) > 0) {
					cur = max;
					temp = tree.array[i];
					tree.array[i] = max;
					
					tree.array = swapValues(tree.array, tree.rightIndex(i), tree.parentIndex(i));
				}
				
				maxHeapify(tree.rightIndex(i));
			}
		}
	}
	
	public void maxHeapify(int index) {
		if(tree.leftIndex(index) != -1 && 
			tree.leftElement(index).compareTo(tree.array[index]) > 0) {
			swapValues(tree.array, tree.leftIndex(index), tree.parentIndex(index));
			maxHeapify(tree.leftIndex(index));
		}
	}
	
	public E[] swapValues(E[] arr, int index1, int index2) {
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
		return arr;
	}
	
	public E genericCompareToMax(E e1, E e2, E e3) {
		if(e1.compareTo(e2) > 0) {
			if(e1.compareTo(e3) > 0) return e1;
			else return e1;
		}else {
			if(e2.compareTo(e3) > 0) return e2;
			else return e3;
		}
	}
	
}
