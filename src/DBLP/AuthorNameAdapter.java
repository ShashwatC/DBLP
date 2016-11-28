package DBLP;

public class AuthorNameAdapter extends Adapter{
	private static AuthorNameAdapter instance;

	private AuthorNameAdapter() {
		super();
	}
	
	public static AuthorNameAdapter getInstance(){
		if (instance==null){
			instance = new AuthorNameAdapter();
		}
		return instance;
	}
	
	public Author parseQuery(String name){
		AuthorNameParser p1 = new AuthorNameParser(XMLfile,name);
		return p1.getAuthor();
	}

}
