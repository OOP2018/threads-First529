
public class SynchronousCounter extends Counter{
	
	@Override
	public synchronized void add (int amount) {
		total += amount;
	}
	
	@Override
	public synchronized void subtract (int amount) {
		total -= amount;
	}

}
