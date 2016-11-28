package DBLP;

import java.util.Date;
import java.util.List;

public class Publication {
	private int key;
	private Date mDate;
	private String title;
	private List<Author> authorList;
	private List<String> authorNameList;
	private String numPages;
	private String year;
	private String volume;
	private String journalBook;
	private String url;
	
	public Publication() {
		// TODO Auto-generated constructor stub
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

}
