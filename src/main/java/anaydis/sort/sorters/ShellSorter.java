package anaydis.sort.sorters;

import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * User: nschejtman
 * Date: 03/09/13
 * Time: 10:42
 */
public class ShellSorter extends HSorter {

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.SHELL;
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        int N = list.size();
        for (int i = N / 3; i >= 1; i = i / 3) {
            sort(comparator, list, i);
        }
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int[] hSequence) {
        for (int i = hSequence.length - 1; i >= 0; i--) {
            sort(comparator, list, hSequence[i]);
        }

    }

}
