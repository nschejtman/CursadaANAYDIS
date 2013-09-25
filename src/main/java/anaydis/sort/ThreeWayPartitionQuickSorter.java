package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicolas
 * Date: 24/09/13
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
public class ThreeWayPartitionQuickSorter extends QuickSorter {
    private AbstractSorter cutoff;
    private final int M;

    public ThreeWayPartitionQuickSorter(int M, AbstractSorter cutoff) {
        this.M = M;
        this.cutoff = cutoff;
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sort(comparator, list, 0, list.size() - 1);
        cutoff.sort(comparator, list);
    }

    @Override
    protected <T> void sort(Comparator<T> comparator, List<T> list, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo;
        int i = lo + 1;
        int gt = hi;

        T pivot = list.get(lo);

        while (i <= gt) {
            int cmp = comparator.compare(list.get(i), pivot);
            if (cmp < 0) swap(list, lt++, i++);
            else if (cmp > 0) swap(list, i, gt--);
            else i++;
        }

        sort(comparator, list, lo, lt - 1);
        sort(comparator, list, gt + 1, hi);
    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK_THREE_PARTITION;
    }
}
