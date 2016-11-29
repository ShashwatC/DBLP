package DBLP;


/** \class MoreThanKQuery
 *  \brief Concrete subclass of Query, passes more than K type queries to parser via adapter, runs resultset functions on it
 * 
 */


import java.util.List;

/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class MoreThanKQuery extends Query {
	private List<String> authors;
	
	public MoreThanKQuery(List<String> parameters, List<Integer> parameters2) {
		super(parameters, parameters2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Publication> parseQuery() {
		return null;
	}
	
	public List<String> parseKQuery(){
		authors = MoreThanKAdapter.getInstance().parseQuery(parameters2.get(0));
		System.out.println(authors.size());
		for (String name : authors){
			System.out.println("Author :"+name);
		}
		return authors;
	}

}
