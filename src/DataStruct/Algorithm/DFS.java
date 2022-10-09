package DataStruct.Algorithm;

import DataStruct.Abstract.GraphNode;
import DataStruct.Template.List.LinkList;

import java.util.function.Function;

public class DFS <T>{
    public void dfs(GraphNode<T> root, Function<T, Void> Func){
        LinkList<GraphNode<T>> neighbours = root.getNeighbour();
        for(GraphNode<T> neighbour : neighbours){
            if(!neighbour.passed()){
                neighbour.pass();
                dfs(neighbour, Func);
            }
        }
        Func.apply(root.getVal());
    }
}
