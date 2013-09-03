package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractSorter implements Sorter, ObservableSorter {
    List<SorterListener> listeners;

    public AbstractSorter(){
        listeners = new ArrayList<SorterListener>();
    }

    @Override
    public void addSorterListener(SorterListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeSorterListener(SorterListener listener) {
        listeners.remove(listener);
    }

    protected <T> void swap(List<T> list, int i, int j) {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);

        //Notify listeners
        for (int k = 0; k < listeners.size(); k++) {
            listeners.get(k).swap(i, j);
        }
    }

    protected <T> boolean greater(Comparator<T> c, List<T> list, int i, int j) {
        //Notify listeners
        for (int k = 0; k < listeners.size(); k++) {
            listeners.get(k).grater(i, j);
        }

        return c.compare(list.get(i), list.get(j)) > 0;
    }

    protected <T> void compExchange(Comparator<T> c, List<T> list, int i, int j) {
        if (greater(c, list, i, j)) {
            swap(list, i, j);
        }
    }




}
