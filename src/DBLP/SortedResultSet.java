package DBLP;

import java.util.Collections;
import java.util.List;


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
	public List<Publication> generateResultSet() {
		Collections.sort(publications, Collections.reverseOrder());
		return publications;
	}

}
