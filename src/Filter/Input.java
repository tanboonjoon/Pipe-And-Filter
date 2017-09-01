package filter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import pipe.Pipe;

public class Input extends Filter{
	private final static String NEW_LINE = System.lineSeparator();
	private final static int ZERO_IGNORE_WORD = 0;
	private HashSet<String> ignoreWordSet;
	private Scanner reader;
	
	public Input(Pipe<String> output) {
		super(null, output);
		reader = new Scanner(System.in);
	}


	@Override
	public synchronized void transform() {
		ignoreWordSet = new HashSet<>();
		getIgnoreWords();
		getMovieTitles();
	}
	
	@SuppressWarnings("unchecked")
	private void getIgnoreWords() {
		System.out.print(NEW_LINE + "Please enter words to ignore(Press enter to input): ");
		String[] ignoreWords = reader.nextLine().split(" ");
		if (ignoreWords.length != ZERO_IGNORE_WORD) {
			List<String> wordList = Arrays.asList(ignoreWords)
					.stream()
					.map(String::toLowerCase)
					.collect(Collectors.toList());
			ignoreWordSet.addAll(wordList);
		}
		output.receiveData(ignoreWordSet);
	}
	
	private void getMovieTitles() {
		System.out.println("Please enter movie title(Enter a empty space to input):");
		String word = reader.nextLine().trim();
		while (!word.isEmpty()) {
			output.receiveData(word);
			word = reader.nextLine();
		}
	}
}
