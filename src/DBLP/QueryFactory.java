package DBLP;

import java.util.List;

public class QueryFactory {

	public QueryFactory(String queryType, List<String> parameters1, List<Integer> parameters2) {
		if (queryType.equals("moreThanK")){
			
		}
		if (queryType.equals("findByAuthor")){
			AuthorNameQuery q = new AuthorNameQuery(parameters1,parameters2);
			q.parseQuery();
		}
		if (queryType.equals("findByTitleTags")){
			TitleTagQuery q = new TitleTagQuery(parameters1,parameters2);
			q.parseQuery();
		}
		if (queryType.equals("predict")){
			
		}
	}

}
