package filter;

import java.util.SortedSet;

import pipe.Pipe;

public class Output extends Filter{
	public Output(Pipe<SortedSet<String>> input) {
		super(input, null);
	}

	@Override
	public synchronized void transform()  {	
		SortedSet<String> sortedWords = (SortedSet<String>) input.sendData();
		if (sortedWords.isEmpty()) {
			System.out.println("OUTPUT: ZERO MOVIE TITLES TO PRINT");
			return;
		}
		System.out.println("==============================OUTPUT===========================================");
		sortedWords.forEach(word -> System.out.println(word));
		
		System.out.println("==============================END OF OUTPUT====================================");
		


	}
	
}
