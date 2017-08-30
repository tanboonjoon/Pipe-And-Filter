package Filter;

import java.util.ArrayList;
import java.util.SortedSet;

import Pipe.Pipe;

public class Output extends Filter{

	public Output(Pipe<SortedSet<String>> input) {
		super(input, null);
	}

	@Override
	public synchronized void transform()  {	
		if (input.isEmpty()) {
			System.err.println("OUTPUT: ZERO MOVIE TITLES TO PRINT");
			System.exit(1);
		}
		SortedSet<String> sortedWords = (SortedSet<String>) input.sendData();
		sortedWords.forEach(word -> System.out.println(word));
		


	}
	
}
