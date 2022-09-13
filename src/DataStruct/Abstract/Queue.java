package DataStruct.Abstract;

public interface Queue <T>{
    /**
     * 判断队列是否为空
     * @return 空则返回true
     */
    boolean queueEmpty();

    /**
     * 元素入队
     * @param x 待入队元素
     */
    void enQueue(T x);

    /**
     * 元素出队
     * @return 出队元素
     */
    T deQueue();

    /**
     * 读取队头元素
     * @return 读取到的元素
     */
    T getHead();
}
