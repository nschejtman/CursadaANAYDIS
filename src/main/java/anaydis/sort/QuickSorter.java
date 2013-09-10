package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicolas
 * Date: 08/09/13
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
public class QuickSorter extends AbstractSorter {

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sort(comparator, list, 0, list.size() - 1);
    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK;
    }

    private <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(comparator, list, lo, hi);
        sort(comparator, list, lo, j - 1);
        sort(comparator, list, j + 1, hi);

    }


    private <T> int partition(@NotNull Comparator<T> comparator, @NotNull List<T> list, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (greater(comparator, list, lo, ++i)) if (i == hi) break;
            while (greater(comparator, list, --j, lo)) if (j == lo) break;
            if (i >= j) break;
            swap(list, i, j);
        }
        swap(list, lo, j);
        return j;

    }
}
