package DataStruct.Abstract;

public interface GraphStorage {
    /**
     * 将边m, n设为存在
     */
    public void set(int m, int n);

    /**
     * 将边m, n设为不存在
     */
    public void empty(int m, int n);

    /**
     * 查询m, n间是否存在边
     */
    public boolean search(int m, int n);
}
