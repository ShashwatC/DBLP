package DBLP;

import java.util.Map;

public class EntityResolutionAdapter extends Adapter{
	private static Map<String,String> mapping;		// Map from Author Name to "Key"
	
	private EntityResolutionAdapter() {
		if (mapping==null){
			mapping = new EntityParser(XMLfile).getMapping();
		}
	}
	
	public static void initialize(){
		new EntityResolutionAdapter();
	}
	
	public static Map<String,String> getAuthorAliases(){
		return mapping;
	}
	
	public static String getUniqueKey(String name){
		if (exists(name)){
			return mapping.get(name);
		}
		return null;
	}
	
	public static boolean exists(String name){
		return mapping.containsKey(name);
	}
	
	public static boolean areSame(String name1, String name2){
		if (mapping==null)return false;
		if (mapping.containsKey(name1) && mapping.containsKey(name2))
			if (mapping.get(name1).equals(mapping.get(name2)))
				return true;
		return false;
	}

}
