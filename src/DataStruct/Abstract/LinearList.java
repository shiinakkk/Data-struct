package DataStruct.Abstract;

public interface LinearList<T>{
    /**
     * 求表长
     * @return 长度
     */
    int Length();

    /**
     * 按值查找元素
     * @param e 查找元素
     * @return 元素位置，没有则返回-1
     */
    int LocateElem(T e);

    /**
     * 按位查找元素
     * @param p 元素位置
     * @return 查找到的元素，超出长度则返回NULL
     */
    T GetElem(int p);

    /**
     * 插入操作
     * @param p 待插入位置
     * @param e 插入元素
     */
    void ListInsert(int p, T e);

    /**
     * 删除操作
     * @param p 待删除位置
     * @return 删除的元素内容
     */
    T ListDelete(int p);

    /**
     * 输出操作
     */
    void PrintList();

    /**
     * 判空操作
     */
    boolean Empty();
}
