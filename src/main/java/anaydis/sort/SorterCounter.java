package anaydis.sort;

/**
 * User: nschejtman
 * Date: 22/08/13
 * Time: 16:19
 */
public class SorterCounter implements SorterListener {
    private int comps;
    private int swaps;

    @Override
    public void grater(int i, int j) {
       comps++;
    }

    @Override
    public void swap(int i, int j) {
        swaps++;
    }

    public void reset(){
        comps = swaps = 0;
    }

    public int getComps() {
        return comps;
    }

    public int getSwaps() {
        return swaps;
    }
}
