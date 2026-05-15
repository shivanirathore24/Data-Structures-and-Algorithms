package minPriorityQueue1;
import java.util.ArrayList;

/*
Problem Statement:
Implement Priority Queue using Min Heap.
*/

public class PriorityQueue<T> {
    private ArrayList<Element<T>> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    // O(log n)
    public void insert(T value, int priority) {
        Element<T> e = new Element<>(value, priority);
        heap.add(e);

        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        // up-heapify
        while (childIndex > 0) {
            if (heap.get(childIndex).priority < heap.get(parentIndex).priority) {
                Element<T> temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);

                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    // O(1)
    public T getMin() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }
        return heap.get(0).value;
    }

    // O(log n)
    public T removeMin() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }

        Element<T> removed = heap.get(0);
        T ans = removed.value;

        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        // down-heapify
        while (leftChildIndex < heap.size()) {
            int minIndex = parentIndex;

            if (heap.get(leftChildIndex).priority < heap.get(minIndex).priority) {
                minIndex = leftChildIndex;
            }

            if (rightChildIndex < heap.size() &&
                    heap.get(rightChildIndex).priority < heap.get(minIndex).priority) {
                minIndex = rightChildIndex;
            }

            if (minIndex == parentIndex) {
                break;
            }

            Element<T> temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);

            parentIndex = minIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
        }
        return ans;
    }

    // O(1)
    public int size() {
        return heap.size();
    }

    // O(1)
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }
}

/*
Time Complexity:
Insert   : O(log n)
Remove   : O(log n)
Get Min  : O(1)

Space Complexity:
O(n)
- Heap stores all elements

Explanation:
- Priority Queue is implemented using Min Heap
- Smaller priority element stays at top
- insert() uses up-heapify
- removeMin() uses down-heapify
*/