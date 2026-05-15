package assignments;

/*
Problem Statement:
Check whether given array represents Max Heap or not.
*/

public class CheckMaxHeap {
    // O(n)
    public static boolean checkMaxHeap(int arr[]) {
        int n = arr.length;

        // check all parent nodes
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;

            // check left child
            if (arr[i] < arr[leftChildIndex]) {
                return false;
            }

            // check right child
            if (rightChildIndex < n &&
                    arr[i] < arr[rightChildIndex]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = {42, 20, 18, 6, 14, 11, 9, 4};
        System.out.println(checkMaxHeap(arr)); // true
    }
}

/*
Time Complexity:
O(n)
- All parent nodes are checked once

Space Complexity:
O(1)
- No extra space is used

Explanation:
- For Max Heap, parent must be greater than children
- Check every parent node with left and right child
- If any child is greater, array is not Max Heap
*/

/*
Sample Input 1:
42 20 18 6 14 11 9 4

Sample Output 1:
true


Sample Input 2:
42 20 50 6 14 11 9 4

Sample Output 2:
false
*/
