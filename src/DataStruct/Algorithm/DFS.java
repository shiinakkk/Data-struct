package DataStruct.Algorithm;

import DataStruct.Abstract.Edge;
import DataStruct.Abstract.GraphNode;
import DataStruct.Template.List.LinkList;

import java.util.function.Function;

public class DFS <Node, Graph, T>{
    public void dfs(Node node, Graph g, Function<T, Void> Func){
        assert node instanceof GraphNode<?> && g instanceof DataStruct.Abstract.Graph<?>;
        GraphNode<T> root = (GraphNode<T>) node;
        DataStruct.Abstract.Graph<T> graph = (DataStruct.Abstract.Graph<T>) g;
        LinkList<Edge<T>> neighbours = graph.getNeighbour(root);
        for(Edge<T> edge : neighbours){
            GraphNode<T> neighbour = edge.getTarget();
            if(!neighbour.passed()){
                neighbour.pass();
                dfs((Node)neighbour, g, Func);
            }
        }
        Func.apply(root.getVal());
    }
}
