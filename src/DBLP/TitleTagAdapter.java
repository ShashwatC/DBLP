package DBLP;

/** \class TitleTagAdapter
 *  \brief Concrete subclass of Adapter, translates title type queries to authorName parsers
 *  
 */

import java.util.List;

/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class TitleTagAdapter extends Adapter {
	
	private static TitleTagAdapter instance;

	private TitleTagAdapter() {
		super();
	}
	
	public static TitleTagAdapter getInstance(){
		if (instance==null){
			instance = new TitleTagAdapter();
		}
		return instance;
	}
	
	public List<Publication> parseQuery(String name){
		TitleTagParser p1 = new TitleTagParser(XMLfile,name);
		return p1.getPublications();
	}
}
