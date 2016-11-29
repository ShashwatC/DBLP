package DBLP;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;

public class TitleTagParser extends XMLParser{
	private int depth = 0;
	private List<Publication> publications;
	private String titleTag;
	private String stringBuilder;
	private List<String> authorList;
	private boolean disabled;
	private int relevanceLimit;
	
	public TitleTagParser(File xmlInput, String titleTag) {
		super(xmlInput);
		this.titleTag = titleTag;
		relevanceLimit = titleTag.length()/5;			// Approx. 20% similarity threshold
		publications = new ArrayList<Publication>();
		super.initParser();
		// TODO Auto-generated constructor stub
	}
	
	public List<Publication> getPublications(){
		return publications;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		if (depth==1){
			if (publications!=null && publications.size()>0){
				if (publications.get(publications.size()-1).getYear()==null){
					System.out.println("Removing it");
					publications.remove(publications.size()-1);
				}
			}
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
				if (authorList==null){
					authorList = new ArrayList<String>();
				}
			}
		}
		depth++;
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		depth--;
		if (!disabled){

			if (qName.equals("author")){	 // If it's an author, add him
				authorList.add(stringBuilder);				
			}
			
			
			else if (qName.equals("title")){ // If it's a title, decide whether to take it, or leave it and everything that comes along
				int relevance = Relevance.calcRelevance(stringBuilder, titleTag);
				if (relevance>relevanceLimit || stringBuilder.equals("Home Page") || stringBuilder.charAt(0)=='('){   	// This is not the publication we're looking for
					disabled = true;	
				}
				else{  		
					// This is the publication we're looking for
					publications.add(new Publication());
					publications.get(publications.size()-1).setAuthorNameList(authorList);
					publications.get(publications.size()-1).setTitle(stringBuilder);
				}
				
				authorList = null;
			}
			else if (depth==2){				
				if (qName.equals("year")){
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
			stringBuilder = "";
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		// TODO Auto-generated method stub
		if (!disabled){			
			stringBuilder+=new String(ch,start,length);										
		}	
	}

}
