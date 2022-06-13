package practice.implementaions.HashTable;

import java.util.ArrayList;
import java.util.Objects;

class Node<K, V> {
    K key;
    V value;
    final int hashCode;
    Node<K, V> next;

    Node(K key, V value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}

public class HashTable<K, V> {
    ArrayList<Node<K, V>> bucketList;
    int size;
    int capacity;

    HashTable() {
        bucketList = new ArrayList<>(10);
        size = 0;
        capacity = 10;

        for(int i=0;i<capacity;i++){
            bucketList.add(null);
        }
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size()==0;
    }

    public final int getHash(K key) {
        return Objects.hashCode(key);
    }

    public int getBucketIndex(K key) {
        int hash = getHash(key);
        int index = hash % capacity;
        return index < 1 ? index * -1 : index;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        int hash = getHash(key);
        Node<K, V> head = bucketList.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hash) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void put(K key, V val){
        int bucketIndex = getBucketIndex(key);
        int hash = getHash(key);

        Node<K,V> head = bucketList.get(bucketIndex);
        //if key is already present
        while(head!=null){
            if(head.key.equals(key) && head.hashCode == hash){
                head.value = val;
                return;
            }
            head = head.next;
        }

        size++;
        head = bucketList.get(bucketIndex);
        Node<K,V> newNode = new Node<>(key, val, hash);
        newNode.next = head;
        bucketList.set(bucketIndex, newNode);

        if((1.0*size/capacity)>=0.7){
            resize();
        }
    }

    private void resize() {
        ArrayList<Node<K,V>> temp = bucketList;
        bucketList = new ArrayList<>();
        capacity = capacity*2;
        size = 0;
        for(Node<K,V> node:temp){
            while(node!=null){
                put(node.key, node.value);
                node= node.next;
            }
        }
    }

    public V remove(K key){
        int bucketIndex = getBucketIndex(key);
        int hash = getHash(key);
        Node<K,V> head = bucketList.get(bucketIndex);
        Node<K,V> prev = null;
        while(head!=null){
            if(head.key.equals(key) && head.hashCode == hash){
                break;
            }
            prev = head;
            head = head.next;
        }
        if(head == null)
            return null;
        size--;
        if (prev != null)
            prev.next = head.next;
        else
            bucketList.set(bucketIndex, head.next);

        return head.value;

    }

}
