package filter;

import java.util.SortedSet;
import java.util.TreeSet;

import pipe.Pipe;

public class Alphabetizer extends Filter{
	
	private SortedSet<String> sortedWords;
	
	@SuppressWarnings("rawtypes")
	public Alphabetizer(Pipe input, Pipe output) {
		super(input, output);
	}

	@Override
	void transform() {
		sortedWords = new TreeSet<>();
		while (!input.isEmpty()) {
			String word = (String) input.sendData();
			sortedWords.add(word);
		}
		output.receiveData(sortedWords);

	}
}
