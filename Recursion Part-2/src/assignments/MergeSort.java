package assignments;

/*
Problem Statement:
Given an array, sort the elements using Merge Sort (recursively) in-place.
*/

public class MergeSort {
    public static void mergeSort(int a[]) {
        // base case
        if (a.length <= 1) {
            return;
        }

        // divide
        int mid = a.length / 2;

        int left[] = new int[mid];
        int right[] = new int[a.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }

        for (int i = mid; i < a.length; i++) {
            right[i - mid] = a[i];
        }

        // recursive calls
        mergeSort(left);
        mergeSort(right);

        // merge
        merge(left, right, a);
    }

    public static void merge(int left[], int right[], int a[]) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }

        // remaining elements
        while (i < left.length) {
            a[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            a[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int a[] = {10, 1, 5, 9, 8, 6, 12, 11, 7};
        mergeSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

/*
Time Complexity:
O(n log n)
- Divide array into halves → log n levels
- Merge step takes O(n) at each level

Space Complexity:
O(n)
- Extra arrays used during merging

Explanation:
- divide array into two halves
- recursively sort both halves
- merge sorted halves into original array
- repeat until array size becomes 1
*/

/*
Sample Input 1:
2 13 4 1 3 6 28

Sample Output 1:
1 2 3 4 6 13 28

Sample Input 2:
9 3 6 2 0

Sample Output 2:
0 2 3 6 9
*/