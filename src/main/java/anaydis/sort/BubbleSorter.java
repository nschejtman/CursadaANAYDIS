package anaydis.sort;

import java.util.Comparator;
import java.util.List;

/**
 * User: nschejtman
 * Date: 26/08/13
 * Time: 16:46
 */
public class BubbleSorter extends AbstractSorter {
    public <T> void sort(Comparator<T> c, List<T> list) {
        int N = list.size();
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                compExchange(c, list, j, j + 1);
            }
        }
    }

}
