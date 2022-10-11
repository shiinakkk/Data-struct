package DataStruct.Algorithm;

import DataStruct.Abstract.Graph;
import DataStruct.Abstract.GraphNode;
import DataStruct.Template.List.LinkList;

import java.util.function.Function;

public class DFS <Node, Graph, T>{
    public void dfs(Node node, Graph g, Function<T, Void> Func){
        assert node instanceof GraphNode<?> && g instanceof DataStruct.Abstract.Graph<?>;
        GraphNode<T> root = (GraphNode<T>) node;
        DataStruct.Abstract.Graph<T> graph = (DataStruct.Abstract.Graph<T>) g;
        LinkList<GraphNode<T>> neighbours = graph.getNeighbour(root);
        for(GraphNode<T> neighbour : neighbours){
            if(!neighbour.passed()){
                neighbour.pass();
                dfs((Node)neighbour, g, Func);
            }
        }
        Func.apply(root.getVal());
    }
}
