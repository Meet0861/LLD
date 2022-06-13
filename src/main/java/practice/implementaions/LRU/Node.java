package practice.implementaions.LRU;


public class Node<K,V> {

    K key;
    V data;
    Node<K,V> prev;
    Node<K,V> next;

    public Node() {
    }

    Node(K key, V data){
        this.key = key;
        this.data = data;
    }

}
