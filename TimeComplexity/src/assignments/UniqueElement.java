package assignments;

/*
Problem Statement:
Given an array of size N = 2M + 1,
M numbers appear twice and one number appears only once.
Find and return the unique number.

Note:
Unique element is always present.
*/

public class UniqueElement {
    public static int findUnique(int[] arr) {
        int xor = 0;

        // XOR all elements
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }

        return xor;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 2, 5, 3, 1, 5};
        System.out.println(findUnique(arr)); // 1
    }
}

/*
Time Complexity:
Single loop → O(n)
Overall → O(n)

Space Complexity:
O(1) → only one variable used

Explanation:
- traverse array and XOR all elements
- duplicate elements cancel each other (a ^ a = 0)
- remaining value is the unique element
*/

/*
Sample Input 1:
2 3 1 6 3 6 2

Sample Output 1:
1

Sample Input 2:
2 4 7 2 7

Sample Output 2:
4

Sample Input 3:
1 3 1 3 6 6 7 10 7

Sample Output 3:
10
*/