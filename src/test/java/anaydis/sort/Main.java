package anaydis.sort;

import anaydis.sort.tester.IntegerDataGenerator;
import anaydis.sort.tester.Tester;

import java.util.ArrayList;
import java.util.List;

/**
 * User: nschejtman
 * Date: 27/08/13
 * Time: 13:48
 */
public class Main {
    public static void main(String[] args) {
        SorterCounter quick = new SorterCounter();
        SorterCounter cut = new SorterCounter();

        InsertionSorter iS = new InsertionSorter();
        iS.addSorterListener(cut);

        CutoffQuickSorter qS = new CutoffQuickSorter(iS);
        qS.addSorterListener(quick);

        Tester.print(qS, 10);
        System.out.println(quick.getComps() + " Comps " + quick.getSwaps() + " Swaps");
        System.out.println(cut.getComps() + " Comps " + cut.getSwaps() + " Swaps");
    }
}
