package anaydis.sort;

import java.util.ArrayList;

/**
 * User: nschejtman
 * Date: 27/08/13
 * Time: 10:41
 */
public class Main {
    public static void main(String[] args) {
        AbstractSorter bs = new SelectionSorter();

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(8);
        list.add(5);
        list.add(6);
        list.add(1);
        list.add(9);
        list.add(3);

        IntegerComparator c = new IntegerComparator();
        SorterCounter sc = new SorterCounter();

        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }

        bs.addSorterListener(sc);
        bs.sort(c, list);
        System.out.println("comps:" + sc.getComps());
        System.out.println("swaps:" + sc.getSwaps());

        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
