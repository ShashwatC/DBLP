import java.util.Collection;
import java.util.List;

public class Author {
	private String primaryName;
	private List<String> otherNames;
	private String title;
	private String url;
	private String additionalNotes;
	private Collection<Publication> papers;
	
	public Author() {
		// TODO Auto-generated constructor stub
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

	public Collection<Publication> getPapers() {
		return papers;
	}

	public void setPapers(Collection<Publication> papers) {
		this.papers = papers;
	}

	
}
