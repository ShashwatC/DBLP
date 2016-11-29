package DBLP;

/** \class RelevanceResultSet
 *  \brief Concrete implementation of ResultSet which gives results sorted by relevance to query subclasses
 *  
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class RelevanceResultSet extends ResultSet{
	private static RelevanceResultSet instance;
	private String title;
	private String authorName;

	public RelevanceResultSet(List<Publication> publications) {
		super(publications);
		// TODO Auto-generated constructor stub
	}
	
	public static RelevanceResultSet getInstance(List<Publication> publications, String title, String authorName){
		if (instance==null){
			instance = new RelevanceResultSet(publications);
			instance.title = title;
			instance.authorName = authorName;
			return instance;
		}
		instance.publications = publications;
		instance.title = title;
		instance.authorName = authorName;
		return instance;
	}

	@Override
	public List<Publication> generateResultSet() {	/// generates the resultSet
		Collections.sort(publications, new Comparator<Publication>() {

			@Override
			public int compare(Publication o1, Publication o2) {
				int d1=0,d2=0;
				if (title!=null){
					d1 = Relevance.tagRelevance(o1.getTitle(), title);
					d2 = Relevance.tagRelevance(o2.getTitle(), title);
					if (d1<d2)return 1;
					if (d1>d2)return -1;
					return 0;
				}
				else{
					// The names may be different but map to the same person. In that case, we will take
					// distance = 0. So if Shashwat Chaudhary and S.C. are same entities, then
					// Even though the strings are very different, we take relevance to be perfect
					if (EntityResolutionAdapter.areSame(o1.getRelevantAuthor(),authorName))
						d1 = 0;
					else
						d1 = Relevance.calcRelevance(o1.getRelevantAuthor(), authorName);
					if (EntityResolutionAdapter.areSame(o2.getRelevantAuthor(),authorName))
						d2 = 0;
					else
						d2 = Relevance.calcRelevance(o2.getRelevantAuthor(), authorName);
					if (d1<d2)return -1;
					if (d1>d2)return 1;
					return 0;
				}
				
			}
			
		});
		return publications;
	}

}
