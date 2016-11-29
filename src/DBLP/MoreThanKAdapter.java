package DBLP;


/** \class MoreThanKAdapter
 *  \brief Concrete subclass of Adapter, translates MoreThanK queries to authorName parsers
 *  
 */

import java.util.List;

/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class MoreThanKAdapter extends Adapter{
	private static MoreThanKAdapter instance;

	private MoreThanKAdapter() {
		super();
	}
	
	public static MoreThanKAdapter getInstance(){
		if (instance==null){
			instance = new MoreThanKAdapter();
		}
		return instance;
	}
	
	public List<String> parseQuery(int k){
		MoreThanKParser p1 = new MoreThanKParser(XMLfile,k);
		return p1.getAuthors();
	}
}
