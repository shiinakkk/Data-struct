package DataStruct.Template.GraphStorage;

import DataStruct.Abstract.GraphStorage;
import DataStruct.Template.Type.EdgeType;

public class AdjacentMatrix implements GraphStorage {
    int[] points;
    EdgeType[][] edges;

    public void set(int m, int n){
        edges[m][n] = EdgeType.Exists;
    }

    public void empty(int m, int n){
        edges[m][n] = EdgeType.None;
    }

    public boolean search(int m, int n){
        return edges[m][n] == EdgeType.Exists;
    }
}
