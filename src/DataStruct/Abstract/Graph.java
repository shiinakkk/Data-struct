package DataStruct.Abstract;

import DataStruct.Template.List.LinkList;

public interface Graph <T>{
    /**
     * 取出相邻节点
     */
    public LinkList<GraphNode<T>> getNeighbour(GraphNode<T> node);
}
