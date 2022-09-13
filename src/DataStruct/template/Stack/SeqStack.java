package DataStruct.template.Stack;


import DataStruct.Abstract.Stack;

public class SeqStack <T> implements Stack<T> {

    private Object[] data;
    private final int capacity;
    private int pointer;

    public SeqStack(){
        capacity = 100;
        data = new Object[100];
        pointer = -1;
    }

    @Override
    public boolean StackEmpty() {
        return pointer == 0;
    }

    @Override
    public void Push(T x) {
        pointer ++;
        assert (pointer < capacity);
        data[pointer] = x;
    }

    @Override
    public T Pop() {
        if(pointer == -1){
            return null;
        }
        pointer --;
        return (T)data[pointer + 1];
    }

    @Override
    public T getTop() {
        if(pointer == -1){
            return null;
        }
        return (T)data[pointer];
    }
}
