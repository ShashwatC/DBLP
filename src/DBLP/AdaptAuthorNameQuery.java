package DBLP;

public class AdaptAuthorNameQuery extends Adapter{
	private static AdaptAuthorNameQuery instance;

	private AdaptAuthorNameQuery() {
		super();
	}
	
	public static AdaptAuthorNameQuery getInstance(){
		if (instance==null){
			instance = new AdaptAuthorNameQuery();
		}
		return instance;
	}
	
	public Author parseQuery(String name){
		AuthorNameParser p1 = new AuthorNameParser(XMLfile,name);
		return p1.getAuthor();
	}

}
