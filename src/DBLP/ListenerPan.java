package DBLP;

import java.util.ArrayList;
import java.util.List;

/** \class ListenerPan
 *  \brief Inferface required for a given panel to be notified against data changes
 */
/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public interface ListenerPan {
    public void setQueryData(int qType, ArrayList<? extends Object> data);
}
