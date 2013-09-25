package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicolas
 * Date: 24/09/13
 * Time: 19:21
 * To change this template use File | Settings | File Templates.
 */
public class MedianOfThreeQuickSorter extends QuickSorter {
    private final int M;
    private AbstractSorter cutoff;

    public MedianOfThreeQuickSorter(int M, AbstractSorter cutoff){
        this.M = M;
        this.cutoff = cutoff;
    }



    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sort(comparator, list, 0, list.size() - 1);
        cutoff.sort(comparator, list);


    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int lo, int hi) {
        if (hi - lo <= M) return;
        swap(list, (lo + hi) / 2, hi - 1);
        compExchange(comparator, list, lo, hi - 1);
        compExchange(comparator, list, lo, hi);
        compExchange(comparator, list, hi - 1, hi);
        int i = partition(comparator, list, lo + 1, hi - 1);
        sort(comparator, list, lo, i - 1);
        sort(comparator, list, i + 1, hi);
    }


    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK_MED_OF_THREE;
    }
}
