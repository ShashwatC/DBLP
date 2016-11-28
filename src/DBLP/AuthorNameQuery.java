package DBLP;

import java.util.List;

public class AuthorNameQuery extends Query{
	private String name;
	private Author theAuthor;
	
	public AuthorNameQuery(List<Object> parameters) {
		super(parameters);
		name = (String)parameters.get(0);
	}

	@Override
	public void parseQuery() {
		// TODO Auto-generated method stub
		theAuthor = AdaptAuthorNameQuery.getInstance().parseQuery(name);
		if (theAuthor.getPrimaryName()==null){
			System.out.println("No author by that name");
		}
		else{
			System.out.println("Author Found");
			int ctr = 1;
			for (Publication p : theAuthor.getPapers()){
				System.out.println("Sno: "+ctr+" Title: "+p.getTitle()+" Year:"+p.getYear() + " pages "+p.getNumPages()+" volume "+p.getVolume()+" journal/booktitle "+ p.getJournalBook() + " url " + p.getUrl());
				for (String name: p.getAuthorNameList()){
					System.out.print(name+" & ");
				}
				System.out.println();
			}
			// We have an author with name, and publications list defined (rest all is null)
			// The publications have name and date defined (rest all is null)
		}
	}

}
