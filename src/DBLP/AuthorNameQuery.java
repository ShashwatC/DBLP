package DBLP;

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
		
	}
	
	private void since(){
		
	}
	
	private void between(){
		
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
			// Processing options
			for (String option: parameters){
				if (option.equals("dateSort"))sortYear();
				if (option.equals("relSort"))sortRel();
				if (option.equals("between"))between();
				if (option.equals("since"))since();
			}
			
			int ctr = 1;
			for (Publication p : theAuthor.getPapers()){
				System.out.println("Sno: "+ctr+" Title: "+p.getTitle()+" Year:"+p.getYear() + " pages "+p.getNumPages()+" volume "+p.getVolume()+" journal/booktitle "+ p.getJournalBook() + " url " + p.getUrl());
				for (String name: p.getAuthorNameList()){
					System.out.print(name+" & ");
				}
				System.out.println();
				ctr++;
			}
			// We have an author with name, and publications list defined (rest all is null)
			// The publications have name and date defined (rest all is null)
		}
	}

}
