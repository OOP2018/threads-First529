
public class SubtractTask implements Runnable{
	
	private Counter counter;
	
	private int limit;

	public SubtractTask(Counter counter, int limit) {
		this.counter = counter;
		this.limit = limit;
	}

	public void run() {
		for (int k = 1; k <= limit; k++)
			counter.subtract(k);
	}

}
