package anaydis.sort;

import anaydis.sort.tester.IntegerDataGenerator;
import anaydis.sort.tester.Tester;

import java.util.ArrayList;

/**
 * User: nschejtman
 * Date: 27/08/13
 * Time: 13:48
 */
public class Main {
    public static void main(String[] args) {
        BubbleSorter bs = new BubbleSorter();
        InsertionSorter is = new InsertionSorter();
        SelectionSorter ss = new SelectionSorter();
        HSorter hs = new HSorter();

        int n = 10000;
        int min = n;
        int max = n;

        for (int i = min; i <= max; i++) {
            System.out.println("Bubble Sorter, " + i + " elements");
            System.out.println("Worst case = " + Tester.testWorst(hs, i));
            System.out.println("Best case = " + Tester.testBest(hs, i));
        }


    }
}
