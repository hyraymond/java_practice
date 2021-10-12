package one_four_six;
import java.util.*;
class LRUCache extends LinkedHashMap<Integer, Integer>{
    int cap;
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        cap = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
        return size() > cap;
    }
    public static void main(String[] args){
        LRUCache a  = new LRUCache(2);
        a.put(1, 2);
        a.put(2, 2);
        a.get(2);
        a.put(3, 2);
        a.put(4, 2);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
