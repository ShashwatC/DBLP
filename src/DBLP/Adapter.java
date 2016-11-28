package DBLP;

import java.io.File;

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
