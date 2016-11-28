package DBLP;

import java.util.List;

public class TitleTagQuery{
	private String title;
	private List<Publication> publications;

	public TitleTagQuery(List<Object> parameters) {
		//super(parameters);
		title = (String)parameters.get(0);	
	}
	
	

}
