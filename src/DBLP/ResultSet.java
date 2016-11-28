package DBLP;

import java.util.List;

public abstract class ResultSet {
	protected List<Publication> publications;
	
	public ResultSet(List<Publication> publications) {
		this.publications = publications;
	}
		
	public abstract List<Publication> generateResultSet();
}
