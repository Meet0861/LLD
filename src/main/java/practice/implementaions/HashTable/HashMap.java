package practice.implementaions.HashTable;

import java.util.Map;
import java.util.Objects;

public class HashMap<K,V> {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int TREEIFY_THRESHOLD = 8;
    private Node<K,V> [] buckets;
    private int size = 0;

    static class Node<K, V> {
        final K key;
        V value;
        final int hash;
        Node<K, V> next;

        public Node(K key, V value, int hash,  Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public final int hashCode(){
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }


        public boolean equals(Object o) {
            if (this == o) return true;
            if(o instanceof Map.Entry){
                Map.Entry<?,?> m = (Map.Entry<?,?>)o;
                return Objects.equals(key, m.getKey()) &&
                        Objects.equals(value, m.getValue());
            }
           return false;
        }


        public final String toString() { return key + "=" + value; }
    }

    public HashMap(){
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public HashMap(int initialCapacity){
        this.buckets = new Node[initialCapacity];
    }

    static final int getHash(Object key ){
        int h;
        return (key==null) ? 0 : (h = key.hashCode()) ^ (h>>>16);
    }

    public void put(K key, V value){
        Node<K,V> node = new Node<>(key, value, getHash(key), null);
        int bucket = getHash(key) % buckets.length;

        Node<K, V> existingNode = buckets[bucket];
        if(existingNode == null){
            buckets[bucket] = existingNode;
            size++;
        }
        else{
            while(existingNode.next!=null){
                if(existingNode.key.equals(key)){
                    existingNode.value= value;
                    break;
                }
                existingNode = existingNode.next;
            }
            existingNode.next = node;
            size++;
        }
    }

    public V getValue(K key){
        Node<K, V> bucket = buckets[getHash(key) % buckets.length];

        while(bucket!=null){
            if(bucket.getKey().equals(key)) {
                return bucket.getValue();
            }
            bucket=bucket.next;
        }
        return null;
    }
}
