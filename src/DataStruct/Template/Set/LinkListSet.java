package DataStruct.Template.Set;

import DataStruct.Abstract.Set;
import DataStruct.Template.List.LinkList;

import java.util.Iterator;
import java.util.function.Predicate;

public class LinkListSet<T> implements Set<T>, Iterable<T>{
    private final LinkList<T> list;

    LinkListSet(){
        list = new LinkList<>();
    }

    @Override
    public boolean isEmpty() {
        return list.Empty();
    }

    @Override
    public void add(T element) {
        list.ListInsert(list.Length(), element);
    }

    @Override
    public LinkListSet<T> removeIf(Predicate<T> predicate) {
        LinkListSet<T> ret = new LinkListSet<>();
        for(int i = 0; i < list.Length(); i ++){
            T ele = list.GetElem(i);
            if(predicate.test(ele)){
                list.ListDelete(i);
                ret.add(ele);
            }
        }
        return ret;
    }

    @Override
    public boolean contains(T ele) {
        return list.LocateElem(ele) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
