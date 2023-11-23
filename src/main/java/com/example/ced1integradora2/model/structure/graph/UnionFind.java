package model.structure.graph;

import java.util.HashMap;
import java.util.Map;

public class UnionFind <T extends Comparable<T>>{
    private Map<T,T> parent;

    public UnionFind() {
        parent = new HashMap<>();
    }

    public void makeSet(T x){
        if(!parent.containsKey(x)){
            parent.put(x,x);
        }
    }

    public T find(T x) {
        T result;

        if(parent.get(x) == x) {
            result = x;
        }else{
            result = find(parent.get(x));
        }
        return result;
    }

    public void union(T value1, T value2) {
        T parentValue1 = find(value1);
        T parentValue2 = find(value2);

        if(!parentValue1.equals(parentValue2)) {
            parent.replace(parentValue1,parentValue2);
        }
    }
}
