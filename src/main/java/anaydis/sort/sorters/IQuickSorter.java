package anaydis.sort.sorters;

import anaydis.sort.AbstractSorter;
import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicolas
 * Date: 14/09/13
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */
public class IQuickSorter extends AbstractSorter {
    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public SorterType getType() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}