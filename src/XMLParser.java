import java.io.File;
import java.util.Collection;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParser extends DefaultHandler {
	File xmlInput;
	Collection<Publication> publications;
	Collection<Author> author;
	
	public XMLParser(File xmlInput) {
		this.xmlInput = xmlInput;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes){
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName){
		
	}

	@Override
	public void characters(char[] ch, int start, int length){
		
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
