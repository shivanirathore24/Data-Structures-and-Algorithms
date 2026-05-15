package inplaceHeapSort;

/*
Problem Statement:
Sort an array in decreasing order using Inplace Heap Sort.
*/

public class InplaceHeapSort {
    // O(log n)
    public static void downHeapify(int[] arr, int i, int n) {
        int parentIndex = i;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        while (leftChildIndex < n) {
            int minIndex = parentIndex;

            if (arr[leftChildIndex] < arr[minIndex]) {
                minIndex = leftChildIndex;
            }

            if (rightChildIndex < n &&
                    arr[rightChildIndex] < arr[minIndex]) {
                minIndex = rightChildIndex;
            }

            if (minIndex == parentIndex) {
                return;
            }

            int temp = arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex] = temp;

            parentIndex = minIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
        }
    }

    // O(n log n)
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // build min heap
        for (int i = (n / 2) - 1; i >= 0; i--) {
            downHeapify(arr, i, n);
        }

        // remove elements one by one
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            downHeapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 7, 3, 8, 9, 6, 1};
        heapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        } // 9 8 7 6 4 3 1
    }
}

/*
Time Complexity:
O(n log n)
- Heap building takes O(n)
- Heapify operations take O(n log n)

Space Complexity:
O(1)
- Sorting is done inplace

Explanation:
- Build Min Heap from array
- Swap root with last element
- Perform down-heapify after every swap
- Min Heap gives decreasing order sorting
*/

/*
Sample Input:
4 7 3 8 9 6 1

Sample Output:
9 8 7 6 4 3 1
*/