package DBLP;

import java.util.Collection;
import java.util.List;

/** \class Author
 *  \brief Creates Author object
 *  
 *  Contains constructor, setter, getter, adder and increment functions
 *  
 */

public class Author {
	private String primaryName;
	private List<String> otherNames;
	private String title;
	private String url;
	private String additionalNotes;
	private List<Publication> papers;
	private String key;
	private int count;
	
	public void incrementCount(){
		count++;
	}
	
	public int getCount(){
		return count;
	}
	
	public Author(String key) {
		this.key = key;
	}
	
	public Author(){
		count = 0;
	}
	
	public void setKey(String key){
		this.key = key;
	}
	
	public String getKey(){
		return key;
	}
	
	public void addPaper(Publication paper){
		papers.add(paper);
	}

	public String getPrimaryName() {
		return primaryName;
	}

	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}

	public List<String> getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(List<String> otherNames) {
		this.otherNames = otherNames;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAdditionalNotes() {
		return additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	public List<Publication> getPapers() {
		return papers;
	}

	public void setPapers(List<Publication> papers) {
		this.papers = papers;
	}

	
}
