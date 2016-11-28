package DBLP;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParser extends DefaultHandler {
	File xmlInput;
	Collection<Publication> publications;
	Collection<Author> author;
	private static XMLParser instance;
	private int depth = 0;
	
	public void parseFile(File xmlInput){
		instance.xmlInput = xmlInput;
		initParser();
	}
	
	public static XMLParser getInstance(){
		if (instance==null){
			instance = new XMLParser();
		}
		return instance;
	}
	
	private XMLParser() {}
	
	public void initParser(){
		System.out.println("Parsing started");
		SAXParserFactory sParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser sParser = sParserFactory.newSAXParser();
			sParser.getXMLReader().setFeature("http://xml.org/sax/features/validation", true);
			sParser.parse(xmlInput, this);
		}
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("Parsing finished");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes){
		for (int i=0; i<depth;i++){
			System.out.print("\t");
		}
		System.out.println("<"+qName+">");
		depth++;
	}
	
	@Override
	public void endElement(String uri, String localName, String qName){
		depth--;
		for (int i=0; i<depth;i++){
			System.out.print("\t");
		}
		System.out.println("</"+qName+">");
	}

	@Override
	public void characters(char[] ch, int start, int length){
		for (int i=0; i<depth;i++){
			System.out.print("\t");
		}
		System.out.println(new String(ch,start,length));
	}

	@Override
    public void warning(SAXParseException exception) throws SAXException {
        throw new SAXException("Parser threw a Warning");
    }

	@Override
    public void error(SAXParseException exception) throws SAXException {
        throw new SAXException("Parser threw an Error");
    }
    
    // No need to Override fatalError since it's implementation in superclass is
    // exactly what we desire, i.e. the program should halt in case of fatal error.

	Collection<Publication> getDBCollection(){
		return publications;
	}
	
	Collection<Author> getAuthorCollection(){
		return author;
	}

}
