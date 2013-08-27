package anaydis.sort;

import java.util.Comparator;
import java.util.List;

/**
 * User: nschejtman
 * Date: 26/08/13
 * Time: 16:47
 */
public class SelectionSorter extends AbstractSorter {
    public <T> void sort(Comparator<T> c, List<T> list, Timer timer) {
        timer.start();
        int N = list.size();
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (greater(c, list, min, j)) min = j;
            }
            swap(list, i, min);
        }
        timer.end();
    }

    public SorterType getType() {
        return SorterType.SELECTION;
    }
}
