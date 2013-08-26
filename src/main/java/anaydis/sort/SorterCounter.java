package anaydis.sort;

/**
 * User: nschejtman
 * Date: 22/08/13
 * Time: 16:19
 */
public class SorterCounter implements SorterListener {
    private int comparations;
    private int swaps;

    @Override
    public void grater(int i, int j) {
       comparations++;
    }

    @Override
    public void swap(int i, int j) {
        swaps++;
    }
}
