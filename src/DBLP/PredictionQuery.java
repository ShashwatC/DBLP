package DBLP;

import java.util.ArrayList;
import java.util.List;

public class PredictionQuery {
	private List<Integer> paperCount;
	private int year;
	private List<String> authors;
	
	public PredictionQuery(List<String> authors, int year){
		this.authors = authors;
		this.year = year;
	}
	
	public List<Integer> predict(){
		for (String s: authors){
			List<String> param = new ArrayList<String>();
			param.add(s);
			List<Publication> p = new QueryFactory("findByAuthor", param, null).getPublications();
			int totalBefore = 0;
			int startYear = year-1;
			for (Publication publ : p){
				if (Integer.parseInt(publ.getYear())<year){
					totalBefore++;
				}
				if (Integer.parseInt(publ.getYear())<startYear){
					startYear = Integer.parseInt(publ.getYear());
				}
			}
			int expectedCount = totalBefore/(year-startYear);
		}
		return paperCount;
	}
}
