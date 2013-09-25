package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicolas
 * Date: 24/09/13
 * Time: 20:08
 * To change this template use File | Settings | File Templates.
 */
public class TopDownMergeSort extends AbstractSorter {

    protected <T> void merge(@NotNull Comparator<T> comparator, @NotNull List<T> list, int lo, int mid, int hi){
        int i = lo;
        int j = mid+1;
        List<T> dummy = new ArrayList<T>();

        for(int k = lo; k<= hi; k++){
            dummy.set(k, list.get(k));
        }

        for(int k=lo; k<=hi; k++){
            if( i>mid) list.set(k, dummy.get(j++));
            else if(j>hi) list.set(k, dummy.get(i++));
            else if(greater(comparator, dummy, i, j)) list.set(k, dummy.get(j++));
            else list.set(k, dummy.get(i++));
        }

    }
    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {

    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.MERGE;
    }
}
