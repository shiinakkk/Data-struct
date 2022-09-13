package DataStruct.template.Queue;

import DataStruct.Abstract.Queue;

public class SeqQueue <T> implements Queue <T> {

    final int capacity;
    int front, rear;
    Object[] data;

    public SeqQueue() {
        this.capacity = 100;
        front = 0;
        rear = 0;
        data = new Object[capacity];
    }


    @Override
    public boolean queueEmpty() {
        return front == rear && data[rear] == null;
    }

    @Override
    public void enQueue(T x) {
        if(rear >= capacity){
            return;
        }
        data[rear] = x;
        rear ++;
    }

    @Override
    public T deQueue() {
        if(queueEmpty()){
            return null;
        }
        T ret = (T)data[front];
        if(front != rear){
            front ++;
        }else{
            data[front] = null;
        }
        return ret;
    }

    @Override
    public T getHead() {
        if(queueEmpty()){
            return null;
        }
        return (T)data[front];
    }
}
