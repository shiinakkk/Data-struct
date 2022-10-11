package DataStruct.Abstract;

import DataStruct.Template.List.LinkList;

public interface GraphNode <T>{
    /**
     * 取出节点信息
     */
    public T getVal();

    /**
     * 是否遍历过
     */
    public boolean passed();

    /**
     * 设置为遍历过
     */
    public void pass();

    /**
     * 设置为未遍历过
     */
    public void set();
}
