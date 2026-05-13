package rehashing;
import java.util.ArrayList;

/*
Problem Statement:
Implement custom HashMap with rehashing.
*/

public class Map<K, V> {
    ArrayList<MapNode<K, V>> buckets;
    int count;
    int numBuckets;

    public Map() {
        buckets = new ArrayList<>();
        numBuckets = 5;

        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
    }

    // O(1)
    public int size() {
        return count;
    }

    // O(1)
    private int getBucketIndex(K key) {
        int hc = key.hashCode();
        int index = hc % numBuckets;
        return index;
    }

    // O(1)
    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);

        // key already exists, update value
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // insert new node at head
        head = buckets.get(bucketIndex);
        MapNode<K, V> newNode = new MapNode<>(key, value);

        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        count++;

        double loadFactor = (1.0 * count) / numBuckets;
        // rehash if load factor exceeds 0.7
        if (loadFactor > 0.7) {
            reHash();
        }
    }

    // O(n)
    private void reHash() {
        System.out.println("Rehashing if loadFactor is greater than 0.7 :");
        ArrayList<MapNode<K, V>> temp = buckets;
        buckets = new ArrayList<>();

        for (int i = 0; i < 2 * numBuckets; i++) {
            buckets.add(null);
        }

        count = 0;
        numBuckets = numBuckets * 2;

        // re-insert all elements
        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);

            while (head != null) {
                K key = head.key;
                V value = head.value;

                insert(key, value);
                head = head.next;
            }
        }
    }

    // O(1)
    public double loadFactor() {
        return (1.0 * count) / numBuckets;
    }

    // O(1)
    public V getValue(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);

        while (head != null) {
            // key found
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    // O(1)
    public V removeKey(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prev = null;

        while (head != null) {
            // key found
            if (head.key.equals(key)) {
                // removing middle node
                if (prev != null) {
                    prev.next = head.next;
                }

                // removing first node
                else {
                    buckets.set(bucketIndex, head.next);
                }

                count--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }
}

/*
Time Complexity:
O(1)
- Insert, remove and search operations take constant time on average

Space Complexity:
O(n)
- Buckets and linked lists store all key-value pairs

Explanation:
- HashMap uses separate chaining for collision handling
- Rehashing doubles bucket size when load factor exceeds 0.7
- Elements are re-inserted into new buckets after rehashing
*/