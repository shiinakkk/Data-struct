package DataStruct.template.Queue;

import DataStruct.Abstract.Queue;

public class CirQueue <T> implements Queue <T> {

    final int capacity;
    int rear, front;
    Object[] data;

    CirQueue(){
        capacity = 100;
        rear = front = 0;
        data = new Object[capacity];
    }

    @Override
    public boolean queueEmpty() {
        return rear == front;
    }

    @Override
    public void enQueue(T x) {
        if((rear + 1) % capacity == front){
            return;
        }
        data[rear] = x;
        rear = (rear + 1) % capacity;
    }

    @Override
    public T deQueue() {
        if(queueEmpty())
            return null;
        T ret = (T)data[front];
        front = (front + 1) % capacity;
        return ret;
    }

    @Override
    public T getHead() {
        if(queueEmpty())
            return null;
        return (T)data[front];
    }
}
