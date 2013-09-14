package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicolas
 * Date: 14/09/13
 * Time: 14:46
 * To change this template use File | Settings | File Templates.
 */
public class CutoffQuickSorter extends QuickSorter {
    AbstractSorter cutoff;

    public CutoffQuickSorter(AbstractSorter cutoff) {
        this.cutoff = cutoff;
        this.listeners.addAll(cutoff.listeners);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sort(comparator, list, 0, list.size() - 1, 6);
    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK_CUT;
    }

    protected <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int lo, int hi, int M) {
        if (hi <= lo) return;
        int j = partition(comparator, list, lo, hi);
        while(j-1-lo> M) sort(comparator, list, lo, j - 1);
        while(hi-j+1>M) sort(comparator, list, j + 1, hi);
        cutoff.sort(comparator, list);
    }


}
