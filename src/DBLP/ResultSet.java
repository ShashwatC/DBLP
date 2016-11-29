package DBLP;


/** \class ResultSet
 *  \brief Abstract class which defines how resultset generating classes should be
 *  
 *  It's subclasses use the protected publications variable set by it's constructor
 *  Concrete subclasses are used by concrete subclasses of query to order the data as required by user
 */


import java.util.List;

public abstract class ResultSet {
	protected List<Publication> publications;
	
	public ResultSet(List<Publication> publications) {
		this.publications = publications;
	}
		
	public abstract List<Publication> generateResultSet();
}
