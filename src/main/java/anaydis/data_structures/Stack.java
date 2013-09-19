package anaydis.data_structures;

import java.lang.Object;

/**
 * Created with IntelliJ IDEA.
 * User: nicolas
 * Date: 14/09/13
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
public class Stack<T> {
    private T[] data;
    private int top;

    public Stack() {
        T[] data = (T[]) new Object[10];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public T peek() {
        if (!isEmpty()) return data[top];
        else return null;
    }

    public int size() {
        return top + 1;
    }

    public void pop(){
        if(isEmpty()) return;
        top--;
    }

    public void push(T element){
        if(top + 1 == data.length) doubleSize();
        data[++top] = element;
    }

    private void doubleSize() {
        T[] dummy = (T[]) new Object[top * 2];
        for(int i = 0; i <= top; i++){
            dummy[i] = data[i];
        }
        data = dummy;
    }

}
