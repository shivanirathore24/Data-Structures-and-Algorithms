package assignments;

/*
Problem Statement:
Rotate the array by D elements towards left.

Note:
- Perform rotation in-place
- Do not return anything
*/

public class RotateArray {
    // reverse helper
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void rotate(int[] arr, int d) {
        int n = arr.length;
        if (n == 0) {
            return;
        }

        d = d % n; // handle large d

        // reverse full array
        reverse(arr, 0, n - 1);
        // reverse first part
        reverse(arr, 0, n - d - 1);
        // reverse second part
        reverse(arr, n - d, n - 1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        rotate(arr, d);

        for (int i : arr) {
            System.out.print(i + " "); // 3 4 5 6 7 1 2
        }
    }
}

/*
Time Complexity:
O(n)

Space Complexity:
O(1) → in-place, no extra memory

Explanation:
- reverse full array
- reverse first (n-d) elements
- reverse last d elements
*/

/*
Sample Input 1:
arr = 1 2 3 4 5 6 7
d = 2

Sample Output 1:
3 4 5 6 7 1 2

Sample Input 2:
arr = 1 2 3 4 5 6 7
d = 0

Sample Output 2:
1 2 3 4 5 6 7

Sample Input 3:
arr = 1 2 3 4
d = 2

Sample Output 3:
3 4 1 2
*/