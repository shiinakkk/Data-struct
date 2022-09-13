package DataStruct.template.List;

import DataStruct.Abstract.LinearList;

public class SeqList <T> implements LinearList <T>{
    private Object []data;
    private int length;
    private int capacity = 50;

    public SeqList(int length){
        this.length = length;
        this.capacity = 2 * length;
        data = new Object[capacity];
    }

    @Override
    public int Length() {
        return this.length;
    }

    @Override
    public int LocateElem(T e) {
        for(int i = 0; i < length; i ++){
            if(e.equals((T)data[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public T GetElem(int p) {
        if(p <= length && p >= 0) {
            return (T)data[p];
        }
        return null;
    }

    @Override
    public void ListInsert(int p, T e) {
        if(p <= 0 || p > length){
            return;
        }
        for(int j = length; j >= p; j --){
            data[j] = data[j - 1];
        }
        data[p] = e;
        length ++;
        // 数组扩容
        if(length == capacity){
            capacity = capacity * 2;
            Object []newData = new Object[capacity];
            for(int i = 0; i < length; i ++){
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    @Override
    public T ListDelete(int p) {
        if(p < 0 || p >= length){
            return null;
        }
        T ret = (T)data[p];
        for(int j = p; j < length; j ++){
            data[j] = data[j + 1];
        }
        length --;
        return ret;
    }

    @Override
    public void PrintList() {
        for(Object obj : data){
            System.out.print(obj);
        }
        System.out.print(System.lineSeparator());
    }

    @Override
    public boolean Empty() {
        return length == 0;
    }
}
