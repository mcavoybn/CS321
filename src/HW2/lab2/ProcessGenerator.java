import java.util.Random;

public class ProcessGenerator {

	private double probability;
	Random rand = new Random();
	
	public ProcessGenerator(double probability) {
		this.probability = probability;
	}
	
	public boolean query() {
		if(rand.nextInt(100) + 1 <= probability*100) {
			return true;
		}
		return false;
	}

	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
		int randomTimeRemaining = rand.nextInt(maxProcessTime) + 1;
		int randomPriorityLevel = rand.nextInt(maxLevel) + 1;
		return new Process(currentTime, randomTimeRemaining, randomPriorityLevel);
	}
	
}
	
	
