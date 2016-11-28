package DBLP;

import java.io.File;
import java.util.List;

import org.xml.sax.Attributes;

public class AuthorNameParser extends XMLParser {
	private int depth;
	private Author theAuthor;
	private boolean checkAuthor = false;
	private String theAuthorName;
	private boolean insidePublication = false;
	private boolean first;
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
		if (depth==2 && qName.equals("author")){
			checkAuthor = true;
		}
		if (insidePublication){
			stringBuilder = "";
			System.out.println("<"+qName+">");
		}
		depth++;
	}
	
	@Override
	public void endElement(String uri, String localName, String qName){
		depth--;
		if (insidePublication){
			if (first){
				first = false;
			}
			else{
				if (depth==1)
					insidePublication = false;
				if (depth==2){
					System.out.println("We got:" +stringBuilder);
				}
			}
		}

	}

	@Override
	public void characters(char[] ch, int start, int length){
		if (checkAuthor){
			String name = new String(ch,start,length);
			if (name.equals(theAuthorName)){
				theAuthor.setPrimaryName(theAuthorName);
				System.out.println("New author entry");
				insidePublication = true;
				first = true;
			}
			checkAuthor = false;
		}
		else if (insidePublication){
			stringBuilder+=new String(ch,start,length);
		}
	}

}
