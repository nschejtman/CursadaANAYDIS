package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class AbstractSorter implements Sorter, ObservableSorter {
    SorterListener listener;

    @Override
    public <T> void sort(@NotNull Comparator<T> c, @NotNull List<T> list) {
    }

    @NotNull
    @Override
    public SorterType getType() {
        return null;
    }

    @Override
    public void addSorterListener(SorterListener listener) {
        this.listener = listener;
    }

    @Override
    public void removeSorterListener(SorterListener listener) {
        listener = null;
    }

    protected <T> void swap(List<T> list, int i, int j) {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }

    protected <T> boolean greater(Comparator<T> c, List<T> list, int i, int j) {
        return c.compare(list.get(i), list.get(j)) > 0;

    }

    protected <T> void compExchange(Comparator<T> c, List<T> list, int i, int j) {
        if (greater(c, list, i, j)) swap(list, i, j);
    }


}
