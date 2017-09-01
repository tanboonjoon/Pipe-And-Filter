package filter;

import java.util.HashSet;

import pipe.Pipe;

public class CircularShift extends Filter{
	private HashSet<String> stopWords;

	public CircularShift(Pipe input, Pipe output) {
		super(input, output);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void transform() {

		stopWords = (HashSet<String>) input.sendData();	
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
