package DBLP;

import java.util.List;

public class QueryFactory {

	public QueryFactory(String queryType, List<Object> parameters) {
		if (queryType.equals("moreThanK")){
			
		}
		if (queryType.equals("findByAuthor")){
			AuthorNameQuery q = new AuthorNameQuery(parameters);
			q.parseQuery();
		}
		if (queryType.equals("findByTitleTags")){
			TitleTagQuery q = new TitleTagQuery(parameters);
			q.parseQuery();
		}
		if (queryType.equals("predict")){
			
		}
	}

}
