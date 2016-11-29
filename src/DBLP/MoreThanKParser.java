package DBLP;

/** \class MoreThanKParser
 *  \brief Concrete subclass of XMLParser, performs more than K type queries passed to it via adapter using SAX
 *  
 */


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;

public class MoreThanKParser extends XMLParser {
	private List<MinimalAuthor> authors;
	private int k;
	private Map<String,MinimalAuthor> mapping;
	private Map<String,String> keyToName;
	private int depth;
	private boolean insidePublication = false;
	private boolean disabled = false;
	private boolean authorFlag;
	private String stringBuilder;
	int count = 0;


	public MoreThanKParser(File xmlInput, int k) {
		super(xmlInput);
		this.k = k;
		mapping = new HashMap<String,MinimalAuthor>();
		authors = new ArrayList<MinimalAuthor>();
		keyToName = new HashMap<String,String>();
		initParser();
	}
	
	public List<String> getAuthors(){
		List<String> validAuthors = new ArrayList<String>();
		Iterator<String> keySetIterator = mapping.keySet().iterator();
		while (keySetIterator.hasNext()){
			String curName = keySetIterator.next();
			MinimalAuthor curAuthor = mapping.get(curName);
			if (curAuthor.getCount()>k){
				if (keyToName.containsKey(curName)){
					curName = keyToName.get(curName);
				}
				validAuthors.add(curName);
			}
		}
		return validAuthors;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes){ /// startElement SAX function
		if (depth==1){
			if (qName.equals("person") || (qName.equals("www") && attributes.getValue("key").substring(0, 9).equals("homepages"))){
				disabled = true;	// Ignore person and homepage fields
			}
			else{
				disabled = false;
			}
		}
		if (!disabled){
			if (depth==2 && qName.equals("author")){
				stringBuilder = "";
				authorFlag = true; 
			}
		}
		depth++;
	}
	
	@Override
	public void endElement(String uri, String localName, String qName){ /// endElement SAX function
		depth--;
		if (!disabled){
			if (qName.equals("author")){	
				if (EntityResolutionAdapter.exists(stringBuilder)){
					String newStringBuilder = EntityResolutionAdapter.getUniqueKey(stringBuilder);
					if (!keyToName.containsKey(newStringBuilder)){
						keyToName.put(newStringBuilder, stringBuilder);
					}
					stringBuilder = newStringBuilder;
				}
				// The stringBuilder is either the author Name, or a unique key
				
				if (!mapping.containsKey(stringBuilder)){
					mapping.put(stringBuilder, new MinimalAuthor());
					count++;
				}
				mapping.get(stringBuilder).incrementCount();
			}
			else if (qName.equals("title")){
				authorFlag = false; // No more author inside this tag's parent
			}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length){ /// characters SAX function
		if (!disabled && authorFlag){			
			stringBuilder+=new String(ch,start,length);										
		}		
	}

}
