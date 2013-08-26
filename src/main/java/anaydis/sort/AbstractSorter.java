package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class AbstractSorter implements Sorter, ObservableSorter {
    SorterListener listener;
    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
    }

    @NotNull
    @Override
    public SorterType getType() {
        return null; //IMPLEMENTATION
    }

    @Override
    public void addSorterListener(SorterListener listener) {
        this.listener = listener;
    }

    @Override
    public void removeListener(SorterListener listener) {
        listener = null;
    }

    protected <T>void swap(Comparator<T> c, List<T> list, int i, int j){}
    protected <T>boolean grater(Comparator<T> c, List<T> list, int i, int j){
        return false;
    }



}
