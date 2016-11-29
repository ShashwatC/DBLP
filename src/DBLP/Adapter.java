package DBLP;

import java.io.File;

/** \class Adapter
 *  \brief Abstract Class which defines methods for Adapter Classes, which communicate between queries and parsers
 *  
 *  Contains constructor and a setter function, which takes the XMLFileLocation as a string as creates a
 *  File object for it's concrete subclasses to use.
 *  As the name suggests, it uses adapter design pattern
 */


public abstract class Adapter {
	protected File XMLfile;
	private static String XMLFileLocation;
	
	public static void setXMLFileLocation(String XMLFile){
		XMLFileLocation = XMLFile;
	}
	
	public Adapter() {
		XMLfile = new File(XMLFileLocation);
		// TODO Auto-generated constructor stub
	}

}
