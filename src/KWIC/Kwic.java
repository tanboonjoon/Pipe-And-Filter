package KWIC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import Filter.Alphabetizer;
import Filter.CircularShift;
import Filter.Input;
import Filter.Output;
import Pipe.Pipe;
import Pipe.Pipeline;

public class Kwic {
	final static int ZERO_IGNORE_WORD = 0;
	public static void main(String[] args) {
		HashSet<String> ignoreWords= new HashSet<>();
		if (args.length != ZERO_IGNORE_WORD) {
			List<String> wordList = Arrays.asList(args)
					.stream()
					.map(String::toLowerCase)
					.collect(Collectors.toList());
			ignoreWords.addAll(wordList);
		}
		Kwic kwic = new Kwic();
		kwic.initialize(ignoreWords);
	}

	@SuppressWarnings("rawtypes")
	private void initialize(HashSet<String> ignoreWords) {
		Pipe inputToCircular = new Pipe();
		Pipe circularToAlpha = new Pipe();
		Pipe alphaToOutput = new Pipe();
		
		Input input = new Input(inputToCircular);
		CircularShift circularShift = new CircularShift(inputToCircular, circularToAlpha, ignoreWords);	
		Alphabetizer alpha = new Alphabetizer(circularToAlpha, alphaToOutput);
		Output output = new Output(alphaToOutput);
		
		Pipeline pineLine = new Pipeline();
		pineLine.addFilter(input)
				.addFilter(circularShift)
				.addFilter(alpha)
				.addFilter(output)
				.run();
	}
}
