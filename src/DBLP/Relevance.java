package DBLP;

/** \class Relevance
 *  \brief Has a static method to calculate the Levenshtein distance between two strings
 *  
 */


/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class Relevance {
	/**
     * Levenshtein distance between s1 and s2, using DP (more the distance, less the relevance).
     */
	public static int calcRelevance(String s1, String s2) {
	    s1 = s1.toLowerCase();
	    s2 = s2.toLowerCase();
	    int [] rel = new int [s2.length() + 1];			
	    for (int j = 0; j < rel.length; j++)
	        rel[j] = j;
	    for (int i = 1; i <= s1.length(); i++) {
	        rel[0] = i;
	        int nw = i - 1;
	        for (int j = 1; j <= s2.length(); j++) {
	            int cj = Math.min(1 + Math.min(rel[j], rel[j - 1]), s1.charAt(i - 1) == s2.charAt(j - 1) ? nw : nw + 1);
	            nw = rel[j];
	            rel[j] = cj;
	        }
	    }
	    return rel[s2.length()];
	}
	
	/**
     * Levenshtein distance not useful for tag based searching, finds number of matching tags
     */
	public static int tagRelevance(String title, String titleTags){
		title = title.toLowerCase();
		titleTags = titleTags.toLowerCase();
		String[] tags = titleTags.split(" ");
		int sum = 0;
		for (String tag: tags){
			sum += substringMatch(tag, title);
		}
		return sum;
	}
	
	private static int substringMatch(String tag, String title){
		int countOccurences=0;
		int i = 0;
		for (int j=0; j<title.length(); j++){
			if (i==tag.length()){
				i = 0;
				countOccurences++;
			}
			if (title.charAt(j)==tag.charAt(i)){
				i++;
			}
			else{
				i=0;
			}
		}
		if (i==tag.length()){
			countOccurences++;
		}

		return countOccurences;
	}

}
