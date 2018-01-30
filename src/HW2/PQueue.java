package HW2;

public class PQueue {

	MaxHeap<Process> heap;
	
	public PQueue() {
		heap = new MaxHeap<Process>(new Process[1000]);
	}
	
	public void enPQueue(Process process) {
		heap.incrementTreeSize();
		heap.set(heap.tree.size-1, process);
		heap.maxHeapifyUp(heap.tree.size-1);
	}
	
	public Process dePQueue() {
		heap.set(0, heap.get(heap.tree.size-1));
		heap.decrementTreeSize();
		return heap.get(heap.tree.size);
	}

	public boolean isEmpty() {
		return heap.tree.size == 0;
	}
	
	public void update(int timeToIncrementPriority, int maxLevel) {
		Process curProcess = null;
		for(int i = (int)Math.floor((heap.tree.size-1)/2); i >= 0; i--) {
			curProcess = heap.get(i);
			curProcess.incremenetTimeNotProcessed();
			if(curProcess.needsPriorityIncrease(timeToIncrementPriority, maxLevel)) {
				curProcess.incrementPriorityLevel();
				heap.maxHeapifyUp(i);
			}
		}
	}
	
	
}
