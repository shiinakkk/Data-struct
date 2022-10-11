package DataStruct.Template.Tree;

import DataStruct.Template.Queue.SeqQueue;
import DataStruct.Template.Stack.SeqStack;

import java.util.function.Function;

public class BinaryTree <T>{
    private final BinaryTreeNode<T> root;

    BinaryTree(BinaryTreeNode<T> root){
        this.root = root;
    }

    void VLR(Function<T, Void> func, boolean useRec){
        if(useRec){
            VLRRec(root, func);
        }else{
            VLRIte(root, func);
        }
    }

    void VLRIte(BinaryTreeNode<T> root, Function<T, Void> func){
        SeqStack<BinaryTreeNode<T>> stack = new SeqStack<>();
        if(root == null) return;
        stack.Push(root);
        while(!stack.StackEmpty()){
            BinaryTreeNode<T> node = stack.getTop();
            func.apply(node.val);
            stack.Pop();
            if(node.left != null){
                stack.Push(node.left);
            }
            if(node.right != null){
                stack.Push(node.right);
            }
        }
    }

    void VLRRec(BinaryTreeNode<T> root, Function<T, Void> func){
        if(root == null){
            return;
        }else{
            func.apply(root.val);
            VLRRec(root.left, func);
            VLRRec(root.right, func);
        }
    }

    void LDR(Function<T, Void> func, boolean useRec){
        if(useRec){
            LDRRec(root, func);
        }else{
            LDRIte(root, func);
        }
    }

    void LDRRec(BinaryTreeNode<T> root, Function<T, Void> func){
        if(root == null){
            return;
        }else{
            LDRRec(root.left, func);
            func.apply(root.val);
            LDRRec(root.right, func);
        }
    }

    void LDRIte(BinaryTreeNode<T> root, Function<T, Void> func){
        SeqStack<BinaryTreeNode<T>> stack = new SeqStack<>();
        BinaryTreeNode<T> node = root;
        if(node != null || !stack.StackEmpty()){
            if(node != null){
                stack.Push(node);
                node = node.left;
            }else{
                node = stack.Pop();
                func.apply(node.val);
                node = node.right;
            }
        }
    }

    void LRD(Function<T, Void> func, boolean useRec){
        if(useRec){
            LRDRec(root, func);
        }else{
            LRDIte(root, func);
        }
    }

    void LRDRec(BinaryTreeNode<T> root, Function<T, Void> func){
        if(root == null){
            return;
        }else{
            LRDRec(root.left, func);
            LRDRec(root.right, func);
            func.apply(root.val);
        }
    }

    void LRDIte(BinaryTreeNode<T> root, Function<T, Void> func){
        if(root == null) return;
        SeqStack<BinaryTreeNode<T>> stack = new SeqStack<>();
        stack.Push(root);
        while(!stack.StackEmpty()){
            BinaryTreeNode<T> node = stack.getTop();
            if(node.passed == 0){
                if(node.right != null && node.right.passed == 0) stack.Push(node.right);
                if(node.left != null && node.left.passed == 0) stack.Push(node.left);
                node.pass();
            }else{
                stack.Pop();
                func.apply(node.val);
            }
        }
    }

    void levelTraversal(Function<T, Void> func){
        SeqQueue<BinaryTreeNode<T>> queue = new SeqQueue<>();
        BinaryTreeNode<T> node = null;
        queue.enQueue(root);
        while(!queue.queueEmpty()){
            if(node == null){
                node = queue.deQueue();
            }else{
                func.apply(node.val);
                queue.enQueue(node.left);
                queue.enQueue(node.right);
            }
        }
    }
}
