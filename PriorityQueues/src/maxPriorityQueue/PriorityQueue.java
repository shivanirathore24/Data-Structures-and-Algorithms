package maxPriorityQueue;
import java.util.ArrayList;

/*
Problem Statement:
Implement Max Priority Queue using Max Heap.
*/

public class PriorityQueue {
    private ArrayList<Integer> heap;
    public PriorityQueue() {
        heap = new ArrayList<Integer>();
    }

    // O(1)
    boolean isEmpty() {
        return heap.size() == 0;
    }

    // O(1)
    int getSize() {
        return heap.size();
    }

    // O(1)
    int getMax() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return heap.get(0);
    }

    // O(log n)
    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        // up-heapify
        while (childIndex > 0) {
            if (heap.get(childIndex) > heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);

                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;

            } else {
                return;
            }
        }
    }

    // O(log n)
    int removeMax() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int ans = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        // down-heapify
        while (leftChildIndex < heap.size()) {
            int maxIndex = parentIndex;

            if (heap.get(leftChildIndex) > heap.get(maxIndex)) {
                maxIndex = leftChildIndex;
            }

            if (rightChildIndex < heap.size() &&
                    heap.get(rightChildIndex) > heap.get(maxIndex)) {
                maxIndex = rightChildIndex;
            }

            if (maxIndex == parentIndex) {
                break;
            }

            int temp = heap.get(maxIndex);
            heap.set(maxIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);

            parentIndex = maxIndex;

            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
        }
        return ans;
    }
}

/*
Time Complexity:
Insert    : O(log n)
RemoveMax : O(log n)
GetMax    : O(1)

Space Complexity:
O(n)
- Heap stores all elements

Explanation:
- Max Priority Queue is implemented using Max Heap
- Largest element stays at root
- insert() uses up-heapify
- removeMax() uses down-heapify
*/