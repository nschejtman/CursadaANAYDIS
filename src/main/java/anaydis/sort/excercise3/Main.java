package anaydis.sort.excercise3;

import anaydis.sort.SelectionSorter;

import java.util.ArrayList;

/**
 * User: nschejtman
 * Date: 27/08/13
 * Time: 17:16
 */
public class Main {
    /*
    This class uses SelectionSorter because it was the fastest Sorter according
    to the tester analysis
     */
    public static void main(String[] args) {
        FullName n1 = new FullName("Nicolas", "Schejtman");
        FullName n2 = new FullName("Jose", "Martinez");
        FullName n3 = new FullName("Pedro", "Colunga");
        FullName n4 = new FullName("Lucas", "Luppani");
        FullName n5 = new FullName("Agustin", "Lopez");
        FullName n6 = new FullName("Emilio", "Lopez");

        ArrayList<FullName> list = new ArrayList<FullName>();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);
        list.add(n6);

        SelectionSorter ss = new SelectionSorter();
        FullNameComparator c = new FullNameComparator();

        for (int i = 0; i < list.size(); i++) {
            list.get(i).print();
        }
        ss.sort(c, list);
        System.out.println("......................");
        for (int i = 0; i < list.size(); i++) {
            list.get(i).print();
        }


    }
}
