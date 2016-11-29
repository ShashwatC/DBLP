package DBLP;

import java.util.List;

/** \class Query
 *  \brief Abstract Class which defines methods for Query Classes, which call the parsers and return data to GUI
 *  
 *  Contains constructor and a setter function, which takes the two parameters, which are list of string, and list of integers
 *  These are modified and stored it's concrete subclasses to use.
 * 
 */

public abstract class Query {
	protected List<String> parameters;
	protected List<Integer> parameters2;
	

	public Query(List<String> parameters,List<Integer> parameters2) {
		if (parameters!=null)
			this.parameters = parameters.subList(1, parameters.size());
		this.parameters2 = parameters2;
		// TODO Auto-generated constructor stub
	}
	
	public abstract List<Publication> parseQuery();

}
