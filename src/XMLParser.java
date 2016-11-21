import java.io.File;
import java.util.Collection;

public class XMLParser {
	File xmlInput;
	Collection<Publication> publications;
	Collection<Author> author;
	
	public XMLParser(File xmlInput) {
		this.xmlInput = xmlInput;
		
	}
	
	Collection<Publication> getDBCollection(){
		return publications;
	}
	
	Collection<Author> getAuthorCollection(){
		return author;
	}

}
