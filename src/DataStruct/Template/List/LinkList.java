package DataStruct.Template.List;

import DataStruct.Abstract.LinearList;

public class LinkList<T> implements LinearList<T> {
    class LinkNode{
        public T node;      // 为null时表示为头节点
        LinkNode next;

        public LinkNode(T e, LinkNode next){
            this.node = e;
            this.next = next;
        }
    }

    private LinkNode headNode;
    private int length;

    public LinkList(){
        headNode = new LinkNode(null, null);
        length = 0;
    }

    @Override
    public int Length() {
        return length;
    }

    @Override
    public int LocateElem(T e) {
        LinkNode pointer = headNode;
        int i;
        for(i = 0; i < length; i ++){
            pointer = pointer.next;
            if(pointer.node.equals(e)){
                break;
            }
        }
        if(i == length) i = -1;
        return i;
    }

    @Override
    public T GetElem(int p) {
        if(p > length) return null;
        LinkNode po = headNode.next;
        for(int i = 0; i < p; i ++){
            po = po.next;
        }
        return po.node;
    }

    @Override
    public void ListInsert(int p, T e) {
        if(p > length){
            return;
        }
        LinkNode po = headNode;
        for(int i = 1; i < p; i ++){
            po = po.next;
        }
        po.next = new LinkNode(e, po.next);
        length ++;
    }

    @Override
    public T ListDelete(int p) {
        if(p > length){ return null; }
        LinkNode po = headNode;
        for(int i = 1; i < p; i ++){
            po = po.next;
        }
        T ret = po.next.node;
        po.next = po.next.next;
        length --;
        return ret;
    }

    @Override
    public void PrintList() {
        LinkNode po = headNode;
        for(int i = 0; i < length; i ++){
            po = po.next;
            System.out.print(po.node);
        }
        System.out.println(System.lineSeparator());
    }

    @Override
    public boolean Empty() { return length == 0; }
}
