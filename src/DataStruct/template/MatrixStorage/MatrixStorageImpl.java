package DataStruct.Template.MatrixStorage;

import DataStruct.Abstract.MatrixStorage;
import DataStruct.Template.type.MatrixType;

public class MatrixStorageImpl implements MatrixStorage {

    private MatrixType type;
    private int[] data;

    public MatrixStorageImpl(int type, int n){
        switch(type){
            case 0:
                this.type = MatrixType.SymmetricalMatrix;
                data = new int[n * (n + 1)/2];
                break;
            case 1:
                this.type = MatrixType.TriangleMatrix;
                data = new int[n * (n + 1)/2 + 1];
                break;
            case 2:
                this.type = MatrixType.TridiagonalMatrix;
                data = new int[3 * n - 2];
                break;
            default:
                assert(false);
        }
    }

    @Override
    public int read(int m, int n) {
        switch(type){
            case TriangleMatrix -> {
                if(m > n){
                    return data[m*(m - 1)/2 + n - 1];
                }else{
                    return data[n*(n - 1)/2 + m - 1];
                }
            }
            case SymmetricalMatrix -> {
                if(m >= n){
                    return data[m*(m - 1)/2 + n - 1];
                }else{
                    return data[data.length - 1];
                }
            }
            case TridiagonalMatrix -> {
                return data[2*m + n - 3];
            }
        }
        return 0;
    }

    @Override
    public void write(int m, int n, int num) {
        switch(type){
            case SymmetricalMatrix -> {
                if(m > n){
                    data[m*(m - 1)/2 + n - 1] = num;
                }else{
                    data[n*(n - 1)/2 + m - 1] = num;
                }
            }
            case TriangleMatrix -> {
                if(m >= n){
                    data[m*(m - 1)/2 + n - 1] = num;
                }else{
                    data[data.length - 1] = num;
                }
            }
            case TridiagonalMatrix -> {
                data[2*m + n - 3] = num;
            }
        }
    }
}
