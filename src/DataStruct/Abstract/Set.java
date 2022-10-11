package DataStruct.Abstract;

import java.util.function.Predicate;

public interface Set <T>{
    /**
     * 判断是否为空集
     * @return 集合为空
     */
    boolean isEmpty();

    /**
     * 添加新元素
     */
    void add(T element);

    /**
     * 删除满足条件的元素
     * @param predicate 筛选器
     * @return 去除的元素集合
     */
    Set<T> removeIf(Predicate<T> predicate);

    /**
     * 判断是否含有ele元素
     */
    boolean contains(T ele);
}
