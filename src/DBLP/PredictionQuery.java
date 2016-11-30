package DBLP;

import java.util.ArrayList;
import java.util.List;

/** \class PredictionQuery
 *  \brief Independent class which uses QueryFactory to make Queries and uses the results for prediction
 * 
 */


/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class PredictionQuery {
	private List<Integer> paperCount;
	private int year;
	private List<String> authors;
	
	public PredictionQuery(List<String> authors, int year){
		this.authors = authors;
		this.year = year;
		paperCount = new ArrayList<Integer>();
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
			System.out.println(totalBefore+" "+startYear+" "+year);
			int expectedCount = totalBefore/(year-startYear);
			paperCount.add(expectedCount);
		}
		return paperCount;
	}
}
