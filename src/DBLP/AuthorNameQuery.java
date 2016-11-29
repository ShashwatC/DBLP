package DBLP;

import java.util.Collections;
import java.util.List;

public class AuthorNameQuery extends Query{
	private String name;
	private Author theAuthor;
	
	public AuthorNameQuery(List<String> parameters, List<Integer> years) {
		super(parameters,years);
		name = parameters.get(0);
	}
	
	private void sortYear(){
		theAuthor.setPapers(SortedResultSet.getInstance(theAuthor.getPapers()).generateResultSet());
	}
	
	private void sortRel(){
		theAuthor.setPapers(RelevanceResultSet.getInstance(theAuthor.getPapers(), null, name).generateResultSet());
	}
	
	private void since(){
		System.out.println("YO");
		theAuthor.setPapers(SinceResultSet.getInstance(theAuthor.getPapers(),parameters2.get(0)).generateResultSet());
	}
	
	private void between(){
		theAuthor.setPapers(BetweenResultSet.getInstance(theAuthor.getPapers(),parameters2.get(0),parameters2.get(1)).generateResultSet());
	}

	@Override
	public void parseQuery() {
		// TODO Auto-generated method stub
		theAuthor = AuthorNameAdapter.getInstance().parseQuery(name);
		if (theAuthor.getPrimaryName()==null){
			System.out.println("No author by that name");
		}
		else{
			System.out.println("Author Found");
			Collections.sort(theAuthor.getPapers());		// Forward sort every time 
			// Processing options
			for (String option: parameters){
				if (option.equals("dateSort"))sortYear();	// Reverse sort
				if (option.equals("relSort"))sortRel();		// Sort by relevance
				if (option.equals("between"))between();		// Filter between two years
				if (option.equals("since"))since();			// Filter start year and end year
			}
			
			int ctr = 1;
			for (Publication p : theAuthor.getPapers()){
				System.out.println("Sno: "+ctr+" Title: "+p.getTitle()+" Year:"+p.getYear() + " pages "+p.getNumPages()+" volume "+p.getVolume()+" journal/booktitle "+ p.getJournalBook() + " url " + p.getUrl());
				if (p.getAuthorNameList()!=null){
					
					for (String name: p.getAuthorNameList()){
						System.out.print(name+" & ");
					}
				}
				System.out.println();
				ctr++;
			}
		}
	}

}
