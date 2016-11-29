package DBLP;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;

public class EntityParser extends XMLParser {
	private boolean insidewww; 
	private boolean insideAuthor;
	private Map<String,String> mapping;		// Map from Author Name to "Key"
	private String curKey;
	private String authorName;
	
	public EntityParser(File xmlInput) {
		super(xmlInput);
		mapping = new HashMap<String,String>();
		authorName = "";
		initParser();
	}
	
	public Map<String, String> getMapping(){
		return mapping;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		if (qName.equals("www")){
			if (attributes.getValue("key").substring(0, 9).equals("homepages")){
				curKey = attributes.getValue("key");
				System.out.println("ye :" + curKey);
				insidewww = true;
			}	
		}
		else if (insidewww && qName.equals("author")){
			insideAuthor = true;
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		// TODO Auto-generated method stub
		if (insidewww && qName.equals("www")){
			insidewww = false;
		}
		else if (insideAuthor && qName.equals("author")){
			insideAuthor = false;
			mapping.put(authorName, curKey);
			authorName = "";
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		// TODO Auto-generated method stub
		if (insideAuthor)
			authorName += new String(ch, start, length);
	}

}
