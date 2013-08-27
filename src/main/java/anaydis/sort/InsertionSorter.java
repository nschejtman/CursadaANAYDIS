package anaydis.sort;

import java.util.Comparator;
import java.util.List;

/**
 * User: nschejtman
 * Date: 26/08/13
 * Time: 16:47
 */
public class InsertionSorter extends AbstractSorter {
    public <T> void sort(Comparator<T> c, List<T> list, Timer timer) {
        timer.start();
        int N = list.size();
        for (int i = 0; i < N - 1; i++) {
            if (greater(c, list, i, i + 1)) {
                compExchange(c, list, i, i + 1);
                for (int j = i; j > 0; j--) {
                    compExchange(c, list, j - 1, j);
                }
            }
        }
        timer.end();
    }
    public SorterType getType() {
        return SorterType.INSERTION;
    }
}
