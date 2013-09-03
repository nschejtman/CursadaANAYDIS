package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * User: nschejtman
 * Date: 03/09/13
 * Time: 10:42
 */
public class ShellSort extends HSorter {

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.SHELL;
    }

    public <T>void sort(Comparator<T> c, List<T> list){
        int N = list.size();
        for(int i=N/3; i>=1; i=i/3){
            sort(c, list, i);
        }
    }

}
