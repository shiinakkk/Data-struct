package DataStruct.Abstract;

/**
 * 无向图的边类似双向图, 即既有(a, b)又有(b, a)
 */
public interface Edge <T>{
    /**
     * 获取源节点
     */
    GraphNode<T> getSource();

    /**
     * 获取目标节点
     */
    GraphNode<T> getTarget();

    /**
     * 获取权值
     * @return 默认为 1
     */
    default int getVal(){
        return 1;
    }
}
