package DBLP;

import java.util.List;

public class TitleTagQuery extends Query{
	private String title;
	private List<Publication> publications;

	public TitleTagQuery(List<Object> parameters) {
		super(parameters);
		title = (String)parameters.get(0);	
	}

	@Override
	public void parseQuery() {
		// TODO Auto-generated method stub
		publications = TitleTagAdapter.getInstance().parseQuery(title);
		if (publications.size()==0){
			System.out.println("No publication with that title tag");
		}
		else{
			System.out.println("Publications found");
			int ctr = 1;
			for (Publication p : publications){
				System.out.println("Sno: "+ctr+" Title: "+p.getTitle()+" Year:"+p.getYear() + " pages "+p.getNumPages()+" volume "+p.getVolume()+" journal/booktitle "+ p.getJournalBook() + " url " + p.getUrl());
				for (String name: p.getAuthorNameList()){
					System.out.print(name+" & ");
				}
				System.out.println();
				ctr++;
			}
		}
	}
	
	

}
