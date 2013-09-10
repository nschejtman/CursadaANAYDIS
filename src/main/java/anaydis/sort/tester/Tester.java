package anaydis.sort.tester;

import anaydis.sort.AbstractSorter;

import java.util.ArrayList;

/**
 * User: nschejtman
 * Date: 27/08/13
 * Time: 13:40
 */
public abstract class Tester {

    public static long testWorst(AbstractSorter sorter, int n) {
        //Set data
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        IntegerDataGenerator generator = new IntegerDataGenerator(list);
        generator.createDescending(n);

        //Test time
        Timer timer = new Timer();
        timer.start();
        sorter.sort(generator.getComparator(), list);
        timer.end();
        return timer.time();
    }

    public static long testBest(AbstractSorter sorter, int n) {
        //Set data
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        IntegerDataGenerator generator = new IntegerDataGenerator(list);
        generator.createAscending(n);

        //Test time
        Timer timer = new Timer();
        timer.start();
        sorter.sort(generator.getComparator(), list);
        timer.end();
        return timer.time();
    }

    public static long testRandom(AbstractSorter sorter, int n) {
        //Set data
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        IntegerDataGenerator generator = new IntegerDataGenerator(list);
        generator.createRandom(n);

        //Test time
        Timer timer = new Timer();
        timer.start();
        sorter.sort(generator.getComparator(), list);
        timer.end();



        System.out.println();
        return timer.time();
    }

}
