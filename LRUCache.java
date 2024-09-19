import java.util.HashMap;

/**
 * Date: 01/01/2024:21:37
 * User: shyamlal
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 * The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
 * <p>
 * Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.
 * <p>
 * NOTE: If you are using any global variables, make sure to clear them in the constructor.
 * <p>
 * Example :
 * <p>
 * Input :
 * capacity = 2
 * set(1, 10)
 * set(5, 12)
 * get(5)        returns 12
 * get(1)        returns 10
 * get(10)       returns -1
 * set(6, 14)    this pushes out key = 5 as LRU is full.
 * get(5)        returns -1
 */
public class LRUCache {
    static int capacity;
    Node h = new Node(-1, -1);
    Node t = new Node(-1, -1);
    HashMap<Integer, Node> hm;

    //Constructor
    public LRUCache(int capacity) {
        h.next = t;
        t.prev = h;
        //dummy linked list (-1) h <=> t(-1)

        LRUCache.capacity = capacity;
        hm = new HashMap<>();
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(1, 10);
        lruCache.set(5, 12);
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(10));
        lruCache.set(6, 14);
        System.out.println(lruCache.get(5));
        lruCache.displayCache();
    }

    public int get(int key) {
        if (hm.containsKey(key)) {
            Node d = hm.get(key);
            remove(d);
            addToTail(d);
            return d.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (hm.containsKey(key)) {
            Node curr = hm.get(key);
            curr.value = value;
            remove(curr);
            addToTail(curr);
        } else {
            if (hm.size() == capacity) {
                hm.remove(h.next.key);
                remove(h.next);
            }
            Node nn = new Node(key, value);
            hm.put(key, nn);
            addToTail(nn);
        }
        // displayCache();
    }

    public void addToTail(Node nn) {
        nn.next = t;
        nn.prev = t.prev;
        t.prev = nn;
        nn.prev.next = nn;
    }

    public void remove(Node x) {
        Node tp = x.prev; //previous node
        Node tn = x.next; //next node
        tp.next = tn;
        tn.prev = tp;
    }

    public void displayCache() {
        Node temp = h;
        while (temp != null) {
            temp = temp.next;
        }
    }

    class Node {
        Integer key;
        Integer value;
        Node prev;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
            prev = null;
            next = null;
        }
    }
}
