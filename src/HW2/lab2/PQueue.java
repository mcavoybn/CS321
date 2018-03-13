public class PQueue {

	MaxHeap<Process> heap;
	
	public PQueue() {
		heap = new MaxHeap<Process>();
	}
	
	public Process dePQueue() {
		heap.swap(0, heap.size()-1);
		Process dequeuedElement = heap.remove(heap.size()-1);
		heap.maxHeapifyDown(0);
		return dequeuedElement;
	}
	
	public void enPQueue(Process process) {
		heap.add(process);
		heap.maxHeapifyUp(heap.size()-1);
	}	

	public boolean isEmpty() {
		return heap.size() == 0;
	}
	
	public void update(int timeToIncrementPriority, int maxLevel) {
		Process cur = null;
		for(int i = heap.size() - 1; i >= 0; i--) {
			cur = heap.get(i);
			cur.incrementTimeNotProcessed();
			if(cur.needsPriorityIncrease(timeToIncrementPriority, maxLevel)) {
				cur.incrementPriorityLevel();
			}
		}
		Process parent = null;
		for(int i = heap.size() - 1; i >= 0; i--) {
			parent = heap.tree.parentElement(i);
			if(parent != null && parent.compareTo(heap.get(i)) < 0){
				heap.swap(i, heap.tree.parentIndex(i));
			}
		}
	}
	
	
}
