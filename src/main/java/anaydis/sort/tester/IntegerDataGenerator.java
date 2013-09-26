package anaydis.sort.tester;

import anaydis.sort.data.DataSetGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * User: nschejtman
 * Date: 27/08/13
 * Time: 11:34
 */
public class IntegerDataGenerator implements DataSetGenerator<Integer> {

    public class IntegerComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1>o2) return 1;
            else if(o1==o2) return 0;
            else return -1;
        }
    }



    public IntegerDataGenerator(){
       ;
    }

    @NotNull
    @Override
    public List<Integer> createAscending(int length) {
        final List<Integer> list = new ArrayList<Integer>(length);
        for(int i=0; i<length; i++){
            list.add(i);
        }
        return list;
    }

    @NotNull
    @Override
    public List<Integer> createDescending(int length) {
        final List<Integer> list = new ArrayList<Integer>(length);
        for(int i=0; i<length; i++){
            list.add(length-i);
        }
        return list;
    }

    @NotNull
    @Override
    public List<Integer> createRandom(int length) {
        final List<Integer> list = new ArrayList<Integer>(length);
        final Random r = new Random();
        for(int i = 0; i<length; i++){
            list.add(r.nextInt(length));
        }
        return list;
    }

    @NotNull
    @Override
    public Comparator<Integer> getComparator() {
        return new IntegerComparator();
    }
}
