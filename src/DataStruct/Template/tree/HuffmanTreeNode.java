package DataStruct.Template.tree;

public class HuffmanTreeNode {
    String val;
    int weight;
    HuffmanTreeNode left;
    HuffmanTreeNode right;

    HuffmanTreeNode(String val, int weight){
        this.val = val;
        this.weight = weight;
    }

    HuffmanTreeNode(String val, int weight, HuffmanTreeNode left, HuffmanTreeNode right){
        this.val = val;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }
}
