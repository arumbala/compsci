package com.arumbala.design.problems;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>();
    }

    public int get(int key) {
        Integer value = this.map.get(key);
        if (value == null) {
            value = -1;
        } else {
            this.put(key, value);
        }
        return value;
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            this.map.remove(key);
        } else if (this.map.size() == this.capacity) {
            Iterator<Integer> it = this.map.keySet().iterator();
            it.next();
            it.remove();
        }
        map.put(key, value);
    }


    // --------------------- Test code with main method ---------------------
    public static void main(String[] args) {
        System.out.println("=== LRU Cache Test ===");

        // Test case
        LRUCache cache = new LRUCache(2); // capacity = 2

        cache.put(1, 1);              // cache: {1=1}
        cache.put(2, 2);              // cache: {1=1, 2=2}
        System.out.println(cache.get(1));  // returns 1

        cache.put(3, 3);              // evicts key 2 (least recently used)
        // cache: {1=1, 3=3}
        System.out.println(cache.get(2));  // returns -1 (not found)

        cache.put(4, 4);              // evicts key 1
        // cache: {3=3, 4=4}
        System.out.println(cache.get(1));  // returns -1 (not found)
        System.out.println(cache.get(3));  // returns 3
        System.out.println(cache.get(4));  // returns 4

        System.out.println("\n=== Another Test ===");
        LRUCache cache2 = new LRUCache(3);

        cache2.put(1, 1);
        cache2.put(2, 2);
        cache2.put(3, 3);
        System.out.println("After putting 1,2,3: " + cache2.map);

        System.out.println(cache2.get(2)); // accesses 2 → becomes most recent
        System.out.println("After get(2): " + cache2.map);

        cache2.put(4, 4); // should evict 1 (least recent before this put)
        System.out.println("After put(4,4): " + cache2.map);
    }
}
