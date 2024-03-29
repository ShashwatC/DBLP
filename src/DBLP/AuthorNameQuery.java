package DBLP;

/** \class AuthorNameQuery
 *  \brief Concrete subclass of Query, passes author type queries to parser via adapter, runs resultset functions on it
 * 
 */


import java.util.Collections;
import java.util.List;

/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class AuthorNameQuery extends Query{
	private String name;
	private List<Publication> publications;
	
	public AuthorNameQuery(List<String> parameters, List<Integer> years) {
		super(parameters,years);
		name = parameters.get(0);
	}
	
	private void sortYear(){
		publications = SortedResultSet.getInstance(publications).generateResultSet();
	}
	
	private void sortRel(){
		publications = RelevanceResultSet.getInstance(publications, null, name).generateResultSet();
	}
	
	private void since(){
		System.out.println("YO");
		publications = SinceResultSet.getInstance(publications,parameters2.get(0)).generateResultSet();
	}
	
	private void between(){
		publications = BetweenResultSet.getInstance(publications,parameters2.get(0),parameters2.get(1)).generateResultSet();
	}

	@Override
	public List<Publication> parseQuery() {
		publications = AuthorNameAdapter.getInstance().parseQuery(name);
		if (publications==null){
			System.out.println("No author by that name");
			return null;
		}
		else{
			System.out.println("Author Found");
			Collections.sort(publications);		// Forward sort every time 
			// Processing options
			for (String option: parameters){
				if (option.equals("dateSort"))sortYear();	// Reverse sort
				if (option.equals("relSort"))sortRel();		// Sort by relevance
				if (option.equals("between"))between();		// Filter between two years
				if (option.equals("since"))since();			// Filter start year and end year
			}
			
			System.out.println("Sending back");
			return publications;
		}
	}

}
