package HW2;

public class Process implements Comparable<Process> {
	
	private int priorityLevel;
	private int timeRemaining;
	private int arrivalTime;
	private int timeNotProcessed;
	
	public Process(int currentTime, int timeRemaining, int priorityLevel) {
		this.arrivalTime = currentTime;
		this.timeRemaining = timeRemaining;
		this.priorityLevel = priorityLevel;
	}

	/////////////////////////////////////////////////
	
	@Override
	public int compareTo(Process proc) {
		if(this.priorityLevel > proc.priorityLevel ) return 1;
		if(this.priorityLevel == proc.priorityLevel ) return 0;
		else return -1;
	}
	
	public boolean finish() {
		return timeRemaining == 0;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getPriority() {
		return priorityLevel;
	}
	
	public int getTimeNotProcessed() {
		return timeNotProcessed;
	}
	
	public int getTimeRemaining() {
		return timeRemaining;
	}
	
	public void incrementPriorityLevel() {
		priorityLevel++;
	}
	
	public void incremenetTimeNotProcessed() {
		timeNotProcessed++;
	}
	
	public boolean needsPriorityIncrease(int timeToIncrementPriority, int maxLevel) {
		if(timeNotProcessed >= timeToIncrementPriority &&
			priorityLevel < maxLevel) {
			return true;
		}
		return false;
	}
	
	public void reduceTimeRemaining() {
		timeRemaining--;
	}	
	
	public void resetTimeNotProcessed() {
		timeNotProcessed = 0;
	}
	
	
	
}
