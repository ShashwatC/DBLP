package DBLP;

import java.util.List;

public class MoreThanKQuery extends Query {
	private List<Publication> publications;
	
	public MoreThanKQuery(List<String> parameters, List<Integer> parameters2) {
		super(parameters, parameters2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Publication> parseQuery() {
		// TODO Auto-generated method stub
		publications = MoreThanKAdapter.getInstance().parseQuery(parameters2.get(0));
		return null;
	}

}
