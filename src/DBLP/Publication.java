package DBLP;

import java.util.Date;
import java.util.List;

/** \class Publication
 *  \brief Creates Publication object
 *  
 *  Contains constructor, setter, getter, adder and increment functions
 *  
 */

/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class Publication implements Comparable<Publication>{
	private int key;
	private Date mDate;
	private String title;
	private List<Author> authorList;
	private List<String> authorNameList;
	private String relevantAuthor;
	private String numPages;
	private String year;
	private String volume;
	private String journalBook;
	private String url;
	
	public Publication() {
		// TODO Auto-generated constructor stub
	}
	
	public String getRelevantAuthor(){
		return relevantAuthor;
	}
	
	public void setRelevantAuthor(String relevantAuthor){
		this.relevantAuthor = relevantAuthor;
	}
	
	public List<String> getAuthorNameList(){
		return authorNameList;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Date getmDate() {
		return mDate;
	}

	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	public String getNumPages() {
		return numPages;
	}

	public void setNumPages(String numPages) {
		this.numPages = numPages;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getJournalBook() {
		return journalBook;
	}

	public void setJournalBook(String journalBook) {
		this.journalBook = journalBook;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setAuthorNameList (List<String> authorNameList){
		this.authorNameList = authorNameList;
	}

	@Override
	public int compareTo(Publication compareTo) {
		// TODO Auto-generated method stub
		if (Integer.parseInt(this.getYear()) < Integer.parseInt(compareTo.getYear()))
			return -1;
		if (Integer.parseInt(this.getYear()) > Integer.parseInt(compareTo.getYear()))
			return 1;
		return 0;
	}
	
	

}
