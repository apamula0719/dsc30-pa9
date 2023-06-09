/*
 * Name: TODO
 * PID: TODO
 */

import java.util.*;

/**
 * Panda cache class
 *
 * @author Aneesh Pamula
 * @since 6/6/2023
 */

public class PandaCache {

    HashMap<Integer, Integer> cache;
    LinkedList<Integer> orderAccessed;
    int capacity;

    /**
     * Initializes a new PandaCache object
     * @param capacity The capacity of the cache
     */
    public PandaCache(int capacity) {
        cache = new HashMap<>(capacity);
        orderAccessed = new LinkedList<>();
        this.capacity = capacity;
    }

    /**
     * Get the zone of the panda with the given ID
     * @param pandaID The ID to search for
     * @return the zone of the panda, or -1 if it does not exist in the cache
     */
    public int get(int pandaID) {
        if(!orderAccessed.isEmpty() && pandaID == orderAccessed.getFirst())//Update the list so that this ID shows up as most recently used
            orderAccessed.removeFirst();
        orderAccessed.addLast(pandaID);
        return cache.getOrDefault(pandaID, -1);
    }

    /**
     * Set a new zone number for a panda. If the cache is full, delete the least recently accessed
     * panda ID
     * @param pandaID The panda whose zone is to be changed
     * @param zoneNumber The new zone
     */
    public void set(int pandaID, int zoneNumber) {
        if(capacity <= cache.size())
            cache.remove(orderAccessed.getFirst());
        cache.put(pandaID, zoneNumber);
        if(!orderAccessed.isEmpty() && pandaID == orderAccessed.getFirst())//Update the list so that this ID shows up as most recently used
            orderAccessed.removeFirst();
        orderAccessed.addLast(pandaID);
    }

    public static void main(String[] args){
        PandaCache cache = new PandaCache(3);
        // initialized with capacity = 3
        cache.set(123, 1);
        cache.set(456, 2);
        cache.set(789, 1);

        System.out.println(cache.get(123));
        cache.set(999, 3);
        System.out.println(cache.get(456));

    }
}