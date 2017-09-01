package main;



import filter.Alphabetizer;
import filter.CircularShift;
import filter.Input;
import filter.Output;
import pipe.Pipe;

public class Kwic {
	public static void main(String[] args) {
		printHeader();
		Kwic kwic = new Kwic();
		kwic.initialize();
	}

	private static void printHeader() {
		System.out.println("==============================KWIC Usage Example=============================");
		System.out.println("Please enter words to ignore(Press enter to input): is the of and as a after");
		System.out.println("Please enter movie title(Enter a empty space to input):");
		System.out.println("Man of Steel");
		System.out.println("Fast and Furious");
		System.out.println("The Day After tomorrow");
		System.out.println();
		System.out.println("=============================================================================");
	}


	@SuppressWarnings("rawtypes")
	private void initialize() {
		Pipe inputToCircular = new Pipe();
		Pipe circularToAlpha = new Pipe();
		Pipe alphaToOutput = new Pipe();
		
		Input input = new Input(inputToCircular);
		CircularShift circularShift = new CircularShift(inputToCircular, circularToAlpha);	
		Alphabetizer alpha = new Alphabetizer(circularToAlpha, alphaToOutput);
		Output output = new Output(alphaToOutput);
		
		while (true) {
			input.run();
			circularShift.run();
			alpha.run();
			output.run();
		}
	}

}
