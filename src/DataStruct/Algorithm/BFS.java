package DataStruct.Algorithm;

import DataStruct.Abstract.Edge;
import DataStruct.Abstract.GraphNode;
import DataStruct.Abstract.Queue;
import DataStruct.Template.List.LinkList;
import DataStruct.Template.Queue.LinkQueue;

import java.util.function.Function;

public class BFS <Node, Graph, T>{
    public void bfs(Node begin, Graph g, Function<T, Void> Func){
        Queue<GraphNode<T>> queue = new LinkQueue<>();
        assert begin instanceof GraphNode<?> && g instanceof DataStruct.Abstract.Graph<?>;
        GraphNode<T> root = (GraphNode<T>) begin;
        DataStruct.Abstract.Graph<T> graph = (DataStruct.Abstract.Graph<T>) g;
        queue.enQueue(root);
        root.passed();
        while(!queue.queueEmpty()){
            GraphNode<T> now = queue.deQueue();
            LinkList<Edge<T>> edges = graph.getNeighbour(now);
            for(Edge<T> edge : edges){
                GraphNode<T> neighbour = edge.getTarget();
                if(!neighbour.passed()) {
                    queue.enQueue(neighbour);
                    neighbour.pass();
                }
            }
            Func.apply(now.getVal());
        }
    }
}
