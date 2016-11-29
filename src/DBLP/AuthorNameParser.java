package DBLP;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;

public class AuthorNameParser extends XMLParser {
	private int depth;
	private Author theAuthor;
	private String theAuthorName;
	private boolean insidePublication = false;
	private boolean disabled = false;
	private String stringBuilder;
	private List<Publication> publications;
	private List<String> authorList;
	private boolean authorFlag;
	private int relevanceLimit;

	public AuthorNameParser(File xmlInput, String theAuthorName) {
		super(xmlInput);
		this.theAuthorName = theAuthorName;
		relevanceLimit = theAuthorName.length()/3;			// Approx. 33% similarity threshold
		theAuthor = new Author();
		theAuthor.setPrimaryName(null);
		publications = new ArrayList<Publication>();
		super.initParser();
		theAuthor.setPapers(publications);
	}
	
	public Author getAuthor(){
		return theAuthor;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes){
		if (depth==1){
			authorList = null;
			if (qName.equals("person")){
				disabled = true;	// Ignore person fields
			}
			else{
				disabled = false;
			}
		}
		if (!disabled){
			
			if (depth==2 && qName.equals("author")){
				stringBuilder = "";
				authorFlag = true; // For author, for other entries insidePublication is there
				if (authorList==null){
					authorList = new ArrayList<String>();
				}
			}
			else if (insidePublication){
				stringBuilder = "";				// If it's insidePublication work in character
			}
		}
		depth++;
	}
	
	@Override
	public void endElement(String uri, String localName, String qName){
		depth--;
		if (!disabled){
			if (qName.equals("author")){	// Do we need to check is author is the guy we want
				authorList.add(stringBuilder);
				
				if (stringBuilder.equals(theAuthorName)){
					theAuthor.setPrimaryName(theAuthorName);
					insidePublication = true;
				}
				else if (Relevance.calcRelevance(stringBuilder, theAuthorName)<=relevanceLimit){
					if (theAuthor.getPrimaryName()==null)
						theAuthor.setPrimaryName(theAuthorName);
					insidePublication = true;
				}
			}
			else if (insidePublication){	// Do we need to read the stringBuilder data
				if (depth==1){
					insidePublication = false;
					authorList = null;
				}
				if (depth==2){
					if (qName.equals("title")){
						authorFlag = false; // It was for author, author has been located
						if (stringBuilder.equals("Home Page")){   // Person's DBLP home page
							stringBuilder = "";
							authorList = null;
							disabled = true;	// Disabled till depth becomes 1 again, i.e. new record comes
						}
						else{
							publications.add(new Publication());
							publications.get(publications.size()-1).setAuthorNameList(authorList);
							authorList = null;
							publications.get(publications.size()-1).setTitle(stringBuilder);
						}
					}
					else if (qName.equals("year")){
						publications.get(publications.size()-1).setYear((stringBuilder));
					}
					else if (qName.equals("pages")){
						publications.get(publications.size()-1).setNumPages((stringBuilder));
					}
					else if (qName.equals("volume")){
						publications.get(publications.size()-1).setVolume(stringBuilder);
					}
					else if (qName.equals("journal") || qName.equals("booktitle")){
						publications.get(publications.size()-1).setJournalBook(stringBuilder);
					}
					else if (qName.equals("url")){
						publications.get(publications.size()-1).setUrl(stringBuilder);
					}
				}
			}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length){
		if (!disabled && (authorFlag || insidePublication)){			
			stringBuilder+=new String(ch,start,length);										
		}		
	}

}
