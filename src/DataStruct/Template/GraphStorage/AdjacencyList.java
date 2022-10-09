package DataStruct.Template.GraphStorage;

import DataStruct.Abstract.GraphStorage;

public class AdjacencyList implements GraphStorage {

    class Node{
        int val;
        Node next;

        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    Node[] points;

    @Override
    public void set(int m, int n) {
        Node point = points[m].next;
        while(point != null){
            if(point.val == n){
                return;
            }
            point = point.next;
        }
        point = points[m].next;
        points[m].next = new Node(n, point);
    }

    @Override
    public void empty(int m, int n) {
        Node point = points[m].next;
        Node save = points[m];
        while(point != null){
            if(point.val == n){
                save.next = point.next;
            }
            save = point;
            point = point.next;
        }
    }

    @Override
    public boolean search(int m, int n) {
        Node point = points[m].next;
        while(point != null){
            if(point.val == n){
                return true;
            }
            point = point.next;
        }
        return false;
    }
}
