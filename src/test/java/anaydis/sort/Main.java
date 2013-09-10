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
        AbstractSorter ts = new QuickSorter();

        ArrayList<Integer> list = new ArrayList<Integer>();
        IntegerDataGenerator generator = new IntegerDataGenerator(list);
        generator.createRandom(10);

        int i = 0;
        while(i<list.size()){
            System.out.println(list.get(i));
            i++;
        }

        ts.sort(generator.getComparator(), list);
        System.out.println("------------------");

        i = 0;
        while(i<list.size()){
            System.out.println(list.get(i));
            i++;
        }




    }
}
