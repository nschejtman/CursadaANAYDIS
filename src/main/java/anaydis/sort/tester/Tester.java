package anaydis.sort.tester;

import anaydis.sort.AbstractSorter;
import anaydis.sort.ShellSorter;

import java.util.ArrayList;

/**
 * User: nschejtman
 * Date: 27/08/13
 * Time: 13:40
 */
public abstract class Tester {

    public static long testDescending(AbstractSorter sorter, int n) {
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

    public static long testAscending(AbstractSorter sorter, int n) {
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

    public static long testAscending(ShellSorter sorter, int n, int[] hSequence) {
        //Set data
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        IntegerDataGenerator generator = new IntegerDataGenerator(list);
        generator.createAscending(n);

        //Test time
        Timer timer = new Timer();
        timer.start();
        sorter.sort(generator.getComparator(), list, hSequence);
        timer.end();


        System.out.println();
        return timer.time();
    }

    public static long testDescending(ShellSorter sorter, int n, int[] hSequence) {
        //Set data
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        IntegerDataGenerator generator = new IntegerDataGenerator(list);
        generator.createDescending(n);

        //Test time
        Timer timer = new Timer();
        timer.start();
        sorter.sort(generator.getComparator(), list, hSequence);
        timer.end();
        return timer.time();
    }

    public static void print(AbstractSorter sorter, int n) {
        //Set data
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        IntegerDataGenerator generator = new IntegerDataGenerator(list);
        generator.createRandom(n);

        //Print unsorted
        int i = 0;
        int M = list.size();
        while (i < M) {
            System.out.println(list.get(i));
            i++;
        }

        //Sort & Print
        sorter.sort(generator.getComparator(), list);
        System.out.println("Now data is sorted--------------------");
        i = 0;
        while (i < M) {
            System.out.println(list.get(i));
            i++;
        }
    }

}
