package minPriorityQueue2;
import java.util.ArrayList;

/*
Problem Statement:
Implement Min Priority Queue using Min Heap.
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
    int size() {
        return heap.size();
    }

    // O(1)
    int getMin() throws PriorityQueueException {
        if (isEmpty()) {
            // throw exception if heap is empty
            throw new PriorityQueueException();
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
            if (heap.get(childIndex) < heap.get(parentIndex)) {
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
    int removeMin() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }
        int ans = heap.get(0);

        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        // down-heapify
        while (leftChildIndex < heap.size()) {
            int minIndex = parentIndex;

            if (heap.get(leftChildIndex) < heap.get(minIndex)) {
                minIndex = leftChildIndex;
            }

            if (rightChildIndex < heap.size() &&
                    heap.get(rightChildIndex) < heap.get(minIndex)) {
                minIndex = rightChildIndex;
            }

            if (minIndex == parentIndex) {
                break;
            }

            int temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);

            parentIndex = minIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
        }
        return ans;
    }
}

/*
Time Complexity:
Insert    : O(log n)
RemoveMin : O(log n)
GetMin    : O(1)

Space Complexity:
O(n)
- Heap stores all elements

Explanation:
- Min Priority Queue is implemented using Min Heap
- Smallest element stays at root
- insert() uses up-heapify
- removeMin() uses down-heapify
*/