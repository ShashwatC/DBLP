package DBLP;

import java.util.Collections;
import java.util.List;

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
