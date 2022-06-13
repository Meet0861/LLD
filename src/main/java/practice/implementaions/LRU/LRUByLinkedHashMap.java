package practice.implementaions.LRU;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUByLinkedHashMap<K,V> implements Cache<K,V>{

    private LinkedHashMap<K,V> map;
    private final int capacity;

    public LRUByLinkedHashMap(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<K,V>(capacity){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size()>capacity;
            }
        };
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public V get(K key){
        return map.getOrDefault(key, null);
    }

    @Override
    public void put(K key, V value){
        map.put(key, value);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public void display(){
        ArrayList<K> keys = new ArrayList<K>(map.keySet());
        System.out.println("no of keys : "+ keys.size());
        for(int i = 0; i<keys.size(); i++){
            System.out.print(keys.get(i) + " ");
        }
    }
}
