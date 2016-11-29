package DBLP;

/** \class MinimalAuthor
 *  \brief An alternate form of Author class, with a constructor, two methods, one variable; memory friendly
 *  
 */

/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class MinimalAuthor {
	private int count;
	
	public MinimalAuthor() {
		count = 0;
	}

	public void incrementCount(){
		count++;
	}
	
	public int getCount(){
		return count;
	}
}
