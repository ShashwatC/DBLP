package DBLP;

import java.util.List;

public class QueryFactory {
	private List<Publication> publications;
	private List<String> authorNames;

	public QueryFactory(String queryType, List<String> parameters1, List<Integer> parameters2) {
		if (queryType.equals("moreThanK")){
			MoreThanKQuery q = new MoreThanKQuery(parameters1, parameters2);
			authorNames = q.parseKQuery();
		}
		if (queryType.equals("findByAuthor")){
			AuthorNameQuery q = new AuthorNameQuery(parameters1,parameters2);
			this.publications = q.parseQuery();
		}
		if (queryType.equals("findByTitleTags")){
			TitleTagQuery q = new TitleTagQuery(parameters1,parameters2);
			this.publications = q.parseQuery();
		}
		if (queryType.equals("predict")){
			
		}
	}
	
	public List<Publication> getPublications(){
		return publications;
	}
	
	public List<String> getAuthorNames(){
		return authorNames;
	}

}
