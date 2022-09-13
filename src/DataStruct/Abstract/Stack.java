package DataStruct.Abstract;

public interface Stack<T>{
    /**
     * 判断一个栈是否为空
     * @return 空则返回true,否则返回false
     */
    boolean StackEmpty();

    /**
     * 元素x进栈
     */
    void Push(T x);

    /**
     * 栈顶元素出栈
     * @return 出栈元素
     */
    T Pop();

    /**
     * 读取栈顶元素
     * @return 读取结果
     */
    T getTop();
}
