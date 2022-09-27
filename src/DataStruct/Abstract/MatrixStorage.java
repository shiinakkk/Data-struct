package DataStruct.Abstract;

public interface MatrixStorage {
    /**
     * 从矩阵中读取元素
     */
    int read(int m, int n);

    /**
     * 向矩阵中写入元素
     */
    void write(int m, int n, int num);
}
