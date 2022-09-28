package DataStruct.Template.tree;

public class BinaryTreeNode <T>{
    T val;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    /**
     * 后序遍历使用
     */
    int passed;

    BinaryTreeNode(){
        passed = 0;
    }

    BinaryTreeNode(T val){
        this.val = val;
        this.left = null;
        this.right = null;
        passed = 0;
    }

    BinaryTreeNode(BinaryTreeNode<T> left, BinaryTreeNode<T> right, T val){
        this.left = left;
        this.right = right;
        this.val = val;
        passed = 0;
    }

    void pass(){
        passed = 1;
    }
}
