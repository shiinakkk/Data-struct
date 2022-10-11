package DataStruct.Abstract;

import DataStruct.Template.List.LinkList;

public interface Graph <T>{
    /**
     * 是否为有向图
     */
    default boolean hasDirect(){
        return false;
    }

    /**
     * 取出有关的边
     */
    default LinkList<Edge<T>> getNeighbour(GraphNode<T> node){
        return new LinkList<Edge<T>>();
    };

    /**
     * 遍历所有的边
     */
    Set<Edge<T>> getEdges();

    /**
     * 遍历所有的点
     */
    Set<GraphNode<T>> getNodes();
}
