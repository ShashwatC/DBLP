package DBLP;

import java.io.File;

import org.xml.sax.Attributes;

public class AuthorNameParser extends XMLParser {
	private int depth;
	private Author theAuthor;
	private boolean checkAuthor = false;
	private String theAuthorName;
	private boolean insidePublication = false;
	private boolean disabled = false;
	String stringBuilder;

	public AuthorNameParser(File xmlInput, String theAuthorName) {
		super(xmlInput);
		this.theAuthorName = theAuthorName;
		theAuthor = new Author();
		theAuthor.setPrimaryName(null);
		super.initParser();
	}
	
	public Author getAuthor(){
		return theAuthor;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes){
		if (depth==1){
			if (qName.equals("person")){
				disabled = true;	// Ignore person fields
			}
			else{
				disabled = false;
			}
		}
		if (!disabled){
			if (depth==2 && qName.equals("author")){
				checkAuthor = true;				// If it's author then some work needs to be done in character
				stringBuilder = "";
			}
			else if (insidePublication){
				stringBuilder = "";				// If it's insidePublication work in character
				System.out.println("<"+qName+">");
			}
		}
		depth++;
	}
	
	@Override
	public void endElement(String uri, String localName, String qName){
		depth--;
		if (!disabled){
			if (checkAuthor){	// Do we need to check is author is the guy we want
				checkAuthor = false;
				if (stringBuilder.equals(theAuthorName)){
					theAuthor.setPrimaryName(theAuthorName);
					System.out.println("New author entry");
					insidePublication = true;
				}
			}
			else if (insidePublication){	// Do we need to read the stringBuilder data
				if (depth==1)
					insidePublication = false;
				if (depth==2){
					System.out.println(stringBuilder);
					System.out.println("</"+qName+">");
				}
			}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length){
		if (!disabled && (checkAuthor || insidePublication)){			
			stringBuilder+=new String(ch,start,length);										
		}		
	}

}
