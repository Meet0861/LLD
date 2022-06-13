package practice.implementaions.HashTable;

public class testHashTable {
    public static void main(String[] args) {
        HashTable<Integer, String> h = new HashTable<>();
        //h.get(0);
        h.put(1, "One");
        System.out.println(h.get(1));
        h.remove(1);
    }

}
