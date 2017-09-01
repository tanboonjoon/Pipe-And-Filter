package pipe;

import java.util.LinkedList;
import java.util.Queue;

public class Pipe<T> {
	private Queue<T> data;
	
	public Pipe() {
		data = new LinkedList<>();
	}
	public void receiveData(T input) {
		data.add(input);
	}
	
	public T sendData() {
		return data.poll();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	
}
