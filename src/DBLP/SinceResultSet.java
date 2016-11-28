package DBLP;

import java.util.List;
import java.util.function.Predicate;

public class SinceResultSet extends ResultSet {
    private static SinceResultSet instance;
    private int startYear;


    public SinceResultSet(List<Publication> publications, int startYear) {
        super(publications);
        this.startYear = startYear;
        // TODO Auto-generated constructor stub
    }

    public static SinceResultSet getInstance(List<Publication> publications, int year){
        if (instance==null){
            instance = new SinceResultSet(publications, year);
            return instance;
        }
        instance.publications = publications;
        instance.startYear = year;
        return instance;
    }
    
    @Override
    public List<Publication> generateResultSet() {
    	Predicate<Publication> condition = p-> Integer.parseInt(p.getYear()) < startYear;
        publications.removeIf(condition);
        return publications;
    }

}
