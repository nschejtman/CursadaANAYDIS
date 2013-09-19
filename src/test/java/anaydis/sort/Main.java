package anaydis.sort;


import anaydis.sort.tester.Tester;

import java.util.Stack;

/**
 * User: nschejtman
 * Date: 27/08/13
 * Time: 13:48
 */
public class Main {
    public static void main(String[] args) {

        InsertionSorter is = new InsertionSorter();
        AbstractSorter s = new CutoffQuickSorter(is);


        for(int i = 100; i<=1000000; i=i*10){
            System.out.println("n=" + i);
            System.out.println("ascending=" + Tester.testAscending(s, i));
            System.out.println("descending=" + Tester.testDescending(s, i));
        }

    }


}