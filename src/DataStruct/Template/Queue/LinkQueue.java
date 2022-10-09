package DataStruct.Template.Queue;

import DataStruct.Abstract.Queue;

public class LinkQueue <T> implements Queue <T> {

    class Node{
        T data;
        Node next;

        Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    Node front, rear;

    public LinkQueue(){
        front = rear = null;
    }

    @Override
    public boolean queueEmpty() {
        return front == null && rear == null;
    }

    @Override
    public void enQueue(T x) {
        if(queueEmpty()){
            front = new Node(x, null);
        }else if(rear == null){
            rear = new Node(x, null);
            front.next = rear;
        }else{
            Node newNode = new Node(x, null);
            rear.next = newNode;
            rear = newNode;
        }
    }

    @Override
    public T deQueue() {
        if(queueEmpty())
            return null;
        T ret = front.data;
        if(rear == null){
            front = null;
        }else{
            front = front.next;
        }
        return ret;
    }

    @Override
    public T getHead() {
        if(queueEmpty())
            return null;
        return front.data;
    }
}
