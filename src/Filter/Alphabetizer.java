package Filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import Pipe.Pipe;

public class Alphabetizer extends Filter{
	
	private SortedSet<String> sortedWords;
	public Alphabetizer(Pipe<String> input, Pipe<SortedSet<String>> output) {
		super(input, output);
		sortedWords = new TreeSet<>();
	}

	@Override
	void transform() {
		if (input.isEmpty()) {
			System.err.println("ALPHBETIZER: NO WORDS TO SORT");
			System.exit(1);
		}
		while (!input.isEmpty()) {
			String word = (String) input.sendData();
			sortedWords.add(word);
		}
		output.receiveData(sortedWords);

	}
}
