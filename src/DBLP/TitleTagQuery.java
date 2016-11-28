package DBLP;

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
		
	}
	
	private void since(){
		
	}
	
	private void between(){
		
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
			for (String option: parameters){
				if (option.equals("dateSort"))sortYear();
				if (option.equals("relSort"))sortRel();
				if (option.equals("between"))between();
				if (option.equals("since"))since();
			}
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
