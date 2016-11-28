package DBLP;

import java.util.List;
import java.util.function.Predicate;

public class BetweenResultSet extends ResultSet {
    private static BetweenResultSet instance;
    private int startYear;
    private int endYear;


    public BetweenResultSet(List<Publication> publications, int startYear, int endYear) {
        super(publications);
        this.startYear = startYear;
        this.endYear = endYear;
        // TODO Auto-generated constructor stub
    }

    public static BetweenResultSet getInstance(List<Publication> publications, int year1, int year2){
        if (instance==null){
            instance = new BetweenResultSet(publications, year1, year2);
            return instance;
        }
        instance.publications = publications;
        instance.startYear = year1;
        instance.endYear = year2;
        return instance;
    }
    
    @Override
    public List<Publication> generateResultSet() {
        Predicate<Publication> condition = p-> Integer.parseInt(p.getYear()) <= startYear;
        Predicate<Publication> condition2 = p-> Integer.parseInt(p.getYear()) >= endYear;
        publications.removeIf(condition);
        publications.removeIf(condition2);
        return publications;
    }

}
