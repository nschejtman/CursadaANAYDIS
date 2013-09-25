package anaydis.sort;


import anaydis.sort.AbstractSorter;
import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: nicolas
 * Date: 14/09/13
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */
public class NRQuickSorter extends QuickSorter {


    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sort(comparator, list, 0, list.size() - 1);

    }

    protected <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int l, int r) {
        Stack<Integer> stack = new Stack();
        stack.push(l);
        stack.push(r);
        while (!stack.isEmpty()) {
            r = stack.pop();
            l = stack.pop();
            if (r <= l) {
                continue;
            }
            int i = partition(comparator, list, l, r);
            if (i - l > r - i) {
                stack.push(l);
                stack.push(i - l);
            }
            stack.push(i + 1);
            stack.push(r);
            if (r - i >= i - l) {
                stack.push(l);
                stack.push(i - 1);
            }

        }
    }

    @Override
    public SorterType getType() {
        return SorterType.QUICK_NON_RECURSIVE;
    }
}
