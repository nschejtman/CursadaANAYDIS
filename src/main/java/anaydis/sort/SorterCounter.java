package anaydis.sort;

import anaydis.sort.gui.SorterListener;

/**
 * User: nschejtman
 * Date: 22/08/13
 * Time: 16:19
 */
public class SorterCounter implements SorterListener {
    private int comps;
    private int swaps;

    @Override
    public void greater(int i, int j) {
       comps++;
    }

    @Override
    public void box(int from, int to) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void copy(int from, int to, boolean copyToAux) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void equals(int i, int j) {
        //To change body of implemented methods use File | Settings | File Templates.
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
