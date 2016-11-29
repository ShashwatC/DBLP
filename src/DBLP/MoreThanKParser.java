package DBLP;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;

public class MoreThanKParser extends XMLParser {
	private List<Publication> publications;
	private int k;

	public MoreThanKParser(File xmlInput, int k) {
		super(xmlInput);
		this.k = k;
		publications = new ArrayList<Publication>();
	}
	
	public List<Publication> getPublications(){
		return null;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		// TODO Auto-generated method stub
		
	}

}
