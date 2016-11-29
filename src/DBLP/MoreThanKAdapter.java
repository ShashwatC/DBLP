package DBLP;

import java.util.List;

public class MoreThanKAdapter extends Adapter{
	private static MoreThanKAdapter instance;

	private MoreThanKAdapter() {
		super();
	}
	
	public static MoreThanKAdapter getInstance(){
		if (instance==null){
			instance = new MoreThanKAdapter();
		}
		return instance;
	}
	
	public List<String> parseQuery(int k){
		MoreThanKParser p1 = new MoreThanKParser(XMLfile,k);
		return p1.getAuthors();
	}
}
