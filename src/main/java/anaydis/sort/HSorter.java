package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * User: nschejtman
 * Date: 03/09/13
 * Time: 10:29
 */
public class HSorter extends AbstractSorter{

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.H;
    }

    public <T> void sort(Comparator<T> c, List<T> list){
        sort(c, list, 1);
    }

    public <T>void sort(Comparator<T>c, List<T> list, int h){
        int N = list.size();
        for (int i = 0; i < N - 1; i+=h) {
            if (greater(c, list, i, i + h)) {
                compExchange(c, list, i, i + h);
                for (int j = i; j > 0; j=-h) {
                    compExchange(c, list, j - h, j);
                }
            }
        }

    }
}
