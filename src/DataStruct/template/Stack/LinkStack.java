package DataStruct.Template.Stack;

import DataStruct.Abstract.Stack;

public class LinkStack <T>implements Stack<T> {

    class Node{
        T data;
        Node next;     // 为null时表示为栈底
    }

    private Node top;

    public LinkStack(){
        top = new Node();
        top.data = null;
        top.next = null;
    }

    @Override
    public boolean StackEmpty() {
        return top.next == null;
    }

    @Override
    public void Push(T x) {
        Node newNode = new Node();
        newNode.data = x;
        newNode.next = top;
        top = newNode;
    }

    @Override
    public T Pop() {
        if(top.next == null){
            return null;
        }
        T ret = top.data;
        top = top.next;
        return ret;
    }

    @Override
    public T getTop() {
        return top.data;
    }
}
