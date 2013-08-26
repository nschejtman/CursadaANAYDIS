package anaydis.sort;

/**
 * User: nschejtman
 * Date: 22/08/13
 * Time: 16:14
 */
public interface ObservableSorter {
    void addSorterListener(SorterListener listener);
    void removeListener(SorterListener listener);
}
