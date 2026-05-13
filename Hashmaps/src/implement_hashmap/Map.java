package implement_hashmap;
import java.util.ArrayList;

/*
Problem Statement:
Implement custom HashMap with insert, get, remove and size operations.
*/

public class Map<K, V> {
    ArrayList<MapNode<K, V>> buckets;
    int count;
    int numBuckets;

    public Map() {
        buckets = new ArrayList<>();
        numBuckets = 20;

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
- Linked lists store all inserted key-value pairs

Explanation:
- HashMap is implemented using ArrayList of linked lists
- hashCode() generates bucket index
- Collision handling is done using separate chaining
- Elements are inserted at head of linked list
*/