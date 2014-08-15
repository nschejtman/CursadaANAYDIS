package anaydis.sort;



import anaydis.sort.AbstractSorter;
import anaydis.sort.SorterType;

import java.util.Comparator;
import java.util.List;

/**
 * User: nschejtman
 * Date: 26/08/13
 * Time: 16:47
 */
public class InsertionSorter extends AbstractSorter {
    public <T> void sort( Comparator<T> c, List<T> list) {
        final int N = list.size();
        for (int i = 0; i < N - 1; i++) {
            box(0, i + 1);
            if (greater(c, list, i, i + 1)) {
                compExchange(c, list, i, i + 1);
                for (int j = i; j > 0; j--) {
                    compExchange(c, list, j - 1, j);
                }
            }
        }
    }
    public SorterType getType() {
        return SorterType.INSERTION;
    }
}
