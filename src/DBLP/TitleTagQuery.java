package DBLP;

/** \class TitleTagQuery
 *  \brief Concrete subclass of Query, passes title type queries to parser via adapter, runs resultset functions on it
 * 
 */

import java.util.Collections;
import java.util.List;

public class TitleTagQuery extends Query{
	private String title;
	private List<Publication> publications;
	

	public TitleTagQuery(List<String> parameters, List<Integer> years) {
		super(parameters,years);
		title = parameters.get(0);	
	}
	
	private void sortYear(){
		publications = SortedResultSet.getInstance(publications).generateResultSet();
	}
	
	private void sortRel(){
		publications = RelevanceResultSet.getInstance(publications, title, null).generateResultSet();
	}
	
	private void since(){
		publications = SinceResultSet.getInstance(publications,parameters2.get(0)).generateResultSet();
		
	}
	
	private void between(){
		publications = BetweenResultSet.getInstance(publications,parameters2.get(0),parameters2.get(1)).generateResultSet();
	}

	@Override
	public List<Publication> parseQuery() {
		// TODO Auto-generated method stub
		publications = TitleTagAdapter.getInstance().parseQuery(title);
		if (publications.size()==0){
			System.out.println("No publication with that title tag");
			return null;
		}
		else{
			System.out.println("Publications found");
			Collections.sort(publications); 				// Forward sort every time
			for (String option: parameters){
				if (option.equals("dateSort"))sortYear();	// Reverse sort
				if (option.equals("relSort"))sortRel();		// Sort by relevance
				if (option.equals("between"))between();		// Filter between two years
				if (option.equals("since"))since();			// Filter start year and end year
			}
			int ctr = 1;
			for (Publication p : publications){
				System.out.println("Sno: "+ctr+" Title: "+p.getTitle()+" Year:"+p.getYear() + " pages "+p.getNumPages()+" volume "+p.getVolume()+" journal/booktitle "+ p.getJournalBook() + " url " + p.getUrl());
				if (p.getAuthorNameList()!=null){
					for (String name: p.getAuthorNameList()){
						System.out.print(name+" & ");
					}
				}
				System.out.println();
				ctr++;
			}
			return publications;
		}
	}
	
	

}
