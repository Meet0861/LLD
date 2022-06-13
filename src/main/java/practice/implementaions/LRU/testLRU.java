package practice.implementaions.LRU;

import java.util.LinkedHashMap;

public class testLRU {
    public static void main(String[] args){
        Cache cache = new LRU(5);
        System.out.println("size : " +  cache.size());
        System.out.println("get : " +  cache.get(1));
        cache.put(1, "First");
        System.out.println("size : " +  cache.size());
        System.out.println("get : " +  cache.get(1));
        cache.put(2, "Second");
        cache.put(3, "Thirs");
        cache.put(4, "Fourth");
        cache.put(5, "Fifth");
        cache.display();
        System.out.println("-----------------");
        cache.put(6, "Sixth");
        cache.display();

        System.out.println("-----------------");
        System.out.println("--------USING LINKEDHASHMAP---------");
        cache = new LRUByLinkedHashMap(2);
        System.out.println("size : " +  cache.size());
        System.out.println("get : " +  cache.get(1));
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("size : " +  cache.size());
        System.out.println("get : " +  cache.get(1));
        cache.put(3, 3);
        System.out.println("get : " +  cache.get(2));
        cache.put(4, 4);
        System.out.println("get : " +  cache.get(1));
        System.out.println("get : " +  cache.get(3));
        System.out.println("get : " +  cache.get(4));

    }
}
