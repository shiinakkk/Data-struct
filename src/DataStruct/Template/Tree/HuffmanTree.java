package DataStruct.Template.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class HuffmanTree {
    HuffmanTreeNode root;
    HashMap<String, String> output;

    /**
     * 根据给定的数据和权重建立哈夫曼树
     * @param input 数据和权重
     */
    HuffmanTree(HashMap<String, Integer> input){
        HashSet<HuffmanTreeNode> set = new HashSet<>();
        for(String val : input.keySet()){
            HuffmanTreeNode node = new HuffmanTreeNode(val, input.get(val));
            set.add(node);
        }
        while(set.size() != 1){
            Iterator<HuffmanTreeNode> iterator = set.iterator();
            HuffmanTreeNode min1 = iterator.next(), min2 = iterator.next();
            while(iterator.hasNext()){
                HuffmanTreeNode tmp = iterator.next();
                if(min1.weight < min2.weight){
                    if(tmp.weight < min2.weight){
                        min2 = tmp;
                    }
                }else{
                    if(tmp.weight < min1.weight){
                        min1 = tmp;
                    }
                }
            }
            set.remove(min1);
            set.remove(min2);
            HuffmanTreeNode newNode = new HuffmanTreeNode(null, min1.weight + min2.weight, min1, min2);
            set.add(newNode);
        }
        Iterator<HuffmanTreeNode> iterator = set.iterator();
        root = iterator.next();
    }

    /**
     * 深度优先遍历,输出编码结果
     * @return 代表编码的map
     */
    HashMap<String, String> encoding(){
        output = new HashMap<>();
        dfs("", root);
        return output;
    }

    void dfs(String road, HuffmanTreeNode node){
        if(node.left == null){
            output.put(node.val, road);
        }else{
            dfs(road + "0", node.left);
            dfs(road + "1", node.right);
        }
    }

    public static void main(String[] args){
        HashMap<String, Integer> input = new HashMap<>();
        input.put("a", 7);
        input.put("b", 5);
        input.put("c", 2);
        input.put("d", 4);
        HuffmanTree tree = new HuffmanTree(input);
        HashMap<String, String> output = tree.encoding();
        System.out.println(output);
    }
}
