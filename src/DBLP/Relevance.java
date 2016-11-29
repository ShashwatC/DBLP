package DBLP;

public class Relevance {
	// Levenshtein distance between s1 and s2, using DP (more the distance, less the relevance)
	public static int calcRelevance(String s1, String s2) {
	    s1 = s1.toLowerCase();
	    s2 = s2.toLowerCase();
	    int [] rel = new int [s2.length() + 1];			// DP on relevance
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

}
