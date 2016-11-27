package DBLP;

import java.util.Collection;
import java.util.List;

public class Searcher {
	
	Collection<Publication> dbCollection;
	Collection<Author> authorCollection;
	
	public Searcher() {
				
	}
	
	public Collection<Publication> findByAuthor(String name){
		return null;
	}

	public Collection<Publication> findByTitleTage(List<String> searchTermList){
	    return null;
	}
	
	public Collection<Publication> findGreaterThanNum(int k){
	    return null;
	}
	
	public Integer predictNum(String author, int year){
	    return null;
	}
}
