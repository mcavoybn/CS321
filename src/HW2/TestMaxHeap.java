package HW2;

public class TestMaxHeap {
	
	
	public static void main(String args[]) {
		Integer[] a = { 1, 4 , 8, 4, 7, 21, 7, 152, 52, 4, 4, 5, 1, 340, 4231, 4, 5, 4, 3, 2, 3, 4, 5, 6, 7, 8, 9, 1, 5, 3, 4,34, 25, 23, 4, 23, 42, 23, 3, 5, 2, 5, 25, 3, 35, 35, 2, 5, 3, 52, 235, 235, 5, 2, 3, 5, 35, 23, 235};
		MaxHeap<Integer> m = new MaxHeap<Integer>(a);
		for(int i=0; i<m.tree.array.length; i++) {
			System.out.print(m.tree.array[i] + ", ");
		}
	}

}
