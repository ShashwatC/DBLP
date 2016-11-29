package DBLP;

/** \class SortedResultSet
 *  \brief Concrete implementation of ResultSet which gives sorted results to query subclasses
 *  
 */

import java.util.Collections;
import java.util.List;


/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class SortedResultSet extends ResultSet{
	private static SortedResultSet instance;

	public SortedResultSet(List<Publication> publications) {
		super(publications);
		// TODO Auto-generated constructor stub
	}
	
	public static SortedResultSet getInstance(List<Publication> publications){
		if (instance==null){
			instance = new SortedResultSet(publications);
			return instance;
		}
		instance.publications = publications;
		return instance;
	}

	@Override
	public List<Publication> generateResultSet() { /// generates the resultSet
		Collections.sort(publications, Collections.reverseOrder());
		return publications;
	}

}
