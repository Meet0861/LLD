package practice.implementaions.LRU;

public interface Cache<K,V> {

    boolean isEmpty();

    V get(K key);

    void put(K key, V val);

    int size();

    void clear();

    void display();
}
