package DataStruct.Algorithm;

import DataStruct.Abstract.GraphNode;
import DataStruct.Abstract.Queue;
import DataStruct.Template.List.LinkList;
import DataStruct.Template.Queue.LinkQueue;

import java.util.function.Function;

public class BFS <T>{
    public void bfs(GraphNode<T> root, Function<T, Void> Func){
        Queue<GraphNode<T>> queue = new LinkQueue<>();
        queue.enQueue(root);
        root.passed();
        while(!queue.queueEmpty()){
            GraphNode<T> now = queue.deQueue();
            LinkList<GraphNode<T>> neighbours = now.getNeighbour();
            for(GraphNode<T> neighbour : neighbours){
                if(!neighbour.passed()) {
                    queue.enQueue(neighbour);
                    neighbour.pass();
                }
            }
            Func.apply(now.getVal());
        }
    }
}
