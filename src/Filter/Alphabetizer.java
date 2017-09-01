package filter;

import java.util.SortedSet;
import java.util.TreeSet;

import pipe.Pipe;

public class Alphabetizer extends Filter{
	
	private SortedSet<String> sortedWords;
	public Alphabetizer(Pipe<String> input, Pipe<SortedSet<String>> output) {
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
