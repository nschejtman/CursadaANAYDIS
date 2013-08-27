package anaydis.sort.excercise3;

import java.util.Comparator;

/**
 * User: nschejtman
 * Date: 27/08/13
 * Time: 16:44
 */
public class FullNameComparator implements Comparator<FullName> {

    @Override
    public int compare(FullName o1, FullName o2) {
        if(o1.getLastName().compareTo(o2.getLastName())!=0) return o1.getLastName().compareTo(o2.getLastName());
        else return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
