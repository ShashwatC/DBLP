package DBLP;

/** \class AuthorNameAdapter
 *  \brief Concrete subclass of Adapter, translates authorName queries to authorName parsers
 *  
 */

import java.util.List;

/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class AuthorNameAdapter extends Adapter{
	private static AuthorNameAdapter instance;

	private AuthorNameAdapter() {
		super();
	}
	
	public static AuthorNameAdapter getInstance(){
		if (instance==null){
			instance = new AuthorNameAdapter();
		}
		return instance;
	}
	
	public List<Publication> parseQuery(String name){
		AuthorNameParser p1 = new AuthorNameParser(XMLfile,name);
		if (p1.getAuthor().getPrimaryName()!=null)
			return p1.getAuthor().getPapers();
		else return null;
	}

}
