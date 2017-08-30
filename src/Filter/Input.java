package Filter;

import java.util.Scanner;

import Pipe.Pipe;

public class Input extends Filter{
	
	private Scanner reader;
	public Input(Pipe<String> output) {
		super(null, output);
		reader = new Scanner(System.in);
	}


	@SuppressWarnings("unchecked")
	@Override
	public synchronized void transform() {
		String word = reader.nextLine();
		while (!word.isEmpty()) {
			output.receiveData(word);
			word = reader.nextLine();
		}
	}
}
