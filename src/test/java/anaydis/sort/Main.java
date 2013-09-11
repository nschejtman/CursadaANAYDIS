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
        int[] sequence1 = new int[9];

        //Complete sequence1
        sequence1[0] = 1;
        sequence1[1] = 4;
        sequence1[2] = 13;
        sequence1[3] = 40;
        sequence1[4] = 121;
        sequence1[5] = 264;
        sequence1[6] = 1093;
        sequence1[7] = 3280;
        sequence1[8] = 9841;

        ShellSorter s = new ShellSorter();

        for (int i = 10; i <= 10000000; i *= 10) {
            System.out.println("For n=" + i + " -----------------------------------");
            System.out.println("Ascending");
            System.out.println(Tester.testAscending(s, i, sequence1));
            System.out.println("Descending");
            System.out.println(Tester.testDescending(s, i, sequence1));
        }

    }
}
