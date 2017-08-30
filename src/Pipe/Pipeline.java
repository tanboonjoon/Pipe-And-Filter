package Pipe;

import java.util.ArrayList;
import java.util.List;

import Filter.Filter;

public class Pipeline {
	private List<Filter> filters;
	
	public Pipeline() {
		this.filters = new ArrayList<>();
	}
	public Pipeline addFilter(Filter filter) {
		filters.add(filter);
		return this;
	}
	public void run() {
		filters.forEach(filter -> filter.run());
	}
}
