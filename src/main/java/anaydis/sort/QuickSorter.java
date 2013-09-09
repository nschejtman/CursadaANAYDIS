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
        sort(comparator, list, 0, list.size());
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int hi, int lo) {
        if(hi<=lo) return;
        int i = partition(comparator, list, hi, lo);
        sort(comparator, list, lo, i-1);
        sort(comparator, list, i+1, hi);



    }

    private <T> int partition(@NotNull Comparator<T> comparator, @NotNull List<T> list, int lo, int hi) {
        int i = lo - 1;
        int j = hi;

        while (i < j) {
            while (!greater(comparator, list, i, hi)) {
                i++;
                if (i == j || i == hi) break;
            }
            while (greater(comparator, list, j, hi)) {
                j--;
                if (i == j || j == lo) break;
            }
        }
        swap(list, i, j);
        return i;

    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK;
    }
}
