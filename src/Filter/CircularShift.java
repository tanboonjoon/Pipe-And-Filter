package Filter;

import java.util.HashSet;

import Pipe.Pipe;

public class CircularShift extends Filter{
	private HashSet<String> stopWords;

	public CircularShift(Pipe<String> input, Pipe<String> output, HashSet<String> stopWords) {
		super(input, output);
		this.stopWords = stopWords;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void transform() {
		if (input.isEmpty()) {
			System.err.println("CIRCULAR SHIFT: ZERO MOVIE TITLES TO PROCESS");
			System.exit(1);
		}
		while (!input.isEmpty()) {
			String word = (String) input.sendData();
			String [] splitWords = this.splitWords(word);
			for (int i = 0; i < splitWords.length; i++) {
				String firstWord = splitWords[0].toLowerCase();
				if (!stopWords.contains(firstWord)) {
					String newWord = String.join(" ", splitWords);
					output.receiveData(newWord);
				}
				leftShift(splitWords);
			}
		}
	}
	
	private void leftShift(String[] splitWords) {
		if (splitWords.length == 1) {
			return;
		}
		String firstWordTemp = splitWords[0];
		for (int i = 0; i < splitWords.length - 1; i++) {
			splitWords[i] = splitWords[i+1];
		}
		splitWords[splitWords.length - 1] = firstWordTemp;
	}

	private String[] splitWords(String word) {
		return word.split(" ");
	}

}
