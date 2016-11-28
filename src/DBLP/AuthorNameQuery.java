package DBLP;

import java.util.List;

public class AuthorNameQuery extends Query{
	private String name;
	private Author theAuthor;
	
	public AuthorNameQuery(List<Object> parameters) {
		super(parameters);
		name = (String)parameters.get(0);
	}

	@Override
	public void parseQuery() {
		// TODO Auto-generated method stub
		theAuthor = AdaptAuthorNameQuery.getInstance().parseQuery(name);
		if (theAuthor.getPrimaryName()==null){
			System.out.println("No author by that name");
		}
		else{
			System.out.println("Author Found");
		}
	}

}
