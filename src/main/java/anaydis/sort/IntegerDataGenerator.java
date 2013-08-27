package anaydis.sort;

import anaydis.sort.data.DataSetGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * User: nschejtman
 * Date: 27/08/13
 * Time: 11:34
 */
public class IntegerDataGenerator implements DataSetGenerator<Integer> {
    private List<Integer> list;

    public IntegerDataGenerator(List<Integer> list){
        this.list = list;
    }

    @NotNull
    @Override
    public List<Integer> createAscending(int length) {
        list.clear();
        for(int i=0; i<length; i++){
            list.add(i,i);
        }
        return list;
    }

    @NotNull
    @Override
    public List<Integer> createDescending(int length) {
        list.clear();
        for(int i=0; i<length; i++){
            list.add(i,length-i);
        }
        return list;
    }

    @NotNull
    @Override
    public List<Integer> createRandom(int length) {
        list.clear();
        Random r = new Random();
        for(int i = 0; i<length; i++){
            list.add(i, r.nextInt(length));
        }
        return list;
    }

    @NotNull
    @Override
    public Comparator<Integer> getComparator() {
        return new IntegerComparator();
    }
}
