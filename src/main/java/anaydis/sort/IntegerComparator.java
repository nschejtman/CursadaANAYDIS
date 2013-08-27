package anaydis.sort;

import java.util.Comparator;

/**
 * User: nschejtman
 * Date: 27/08/13
 * Time: 10:44
 */
public class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1>o2) return 1;
        else if(o1==o2) return 0;
        else return -1;
    }
}
