package practice.implementaions.LRU;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LRU<K,V> implements Cache<K,V>{

    private int size, capacity;
    private Map<K,Node> map;
    private Node<K, V> head, tail;

    public LRU(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<K,Node>();
        this.head = new Node<K, V>();
        this.tail = new Node<K, V>();
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next =null;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public V get(K key) {
        V val = null;
        try {
            if (map.get(key) != null) {
                Node<K, V> node = map.get(key);
                deleteNode(node);
                addToFront(node);
                val = (V) node.data;
            }
        }catch (Exception ex){
            System.out.println("exception : " +  ex.getMessage());
        }
        return val;
    }

    @Override
    public void put(K key, V val) {
        if(map.get(key)!=null){
            System.out.println("cache hit --- key , value:" + key + ","+ val);
            Node<K, V> node = map.get(key);
            node.data = val;
            deleteNode(node);
            addToFront(node);
        }
        else{
            System.out.println("cache miss --- key , value:" + key + ","+ val);
            Node<K, V> node = new Node(key, val);
            map.put(key, node);
            if(size<capacity){
                size++;
                addToFront(node);
            }
            else{
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToFront(node);
            }
        }
    }

    private void addToFront(Node<K, V> node) {
        if(node!=null) {
            node.prev = head;
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
        }
    }

    private void deleteNode(Node<K, V> node) {
        if(node!=null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    @Override
    public void display(){
        ArrayList<K> keys = new ArrayList<K>(map.keySet());
        System.out.println("no of keys : "+ keys.size());
        for(int i = keys.size()-1; i>=0; i--){
            System.out.print(keys.get(i) + " ");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        map.clear();
       new LRU(0);
    }
}
