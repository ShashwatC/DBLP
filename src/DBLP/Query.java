package DBLP;

import java.util.List;

public abstract class Query {
	protected List<String> parameters;
	protected List<Integer> parameters2;
	

	public Query(List<String> parameters,List<Integer> parameters2) {
		this.parameters = parameters.subList(1, parameters.size());
		this.parameters2 = parameters2;
		// TODO Auto-generated constructor stub
	}
	
	public abstract void parseQuery();

}
