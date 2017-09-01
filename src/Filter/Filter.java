package filter;

import pipe.Pipe;

abstract public class Filter{
	protected Pipe input;
	protected Pipe output;
		
	public Filter(Pipe input, Pipe output) {
		this.input = input;
		this.output = output;
		
	}
	
	public void run() {
		transform();
	}
	abstract void transform();

	
	  
}
