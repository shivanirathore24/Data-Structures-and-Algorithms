package timeComplexity;

/*
Problem Statement:
Find the Equilibrium Index of an array.
An index i is called equilibrium index if:
sum of elements from 0 to i-1 == sum of elements from i+1 to n-1

Note:
- Element at index i is not included in either sum
- Return first such index
- If none exists, return -1
*/

public class ArrayEquilibriumIndex {

    public static int arrayEquilibriumIndex(int[] arr) {
        int sum = 0;
        // total sum of array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int leftSum = 0;
        // traverse array
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i]; // right sum
            if (leftSum == sum) {
                return i;
            }
            leftSum += arr[i]; // update left sum
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 9, 3, 2};
        System.out.println(arrayEquilibriumIndex(arr)); // 2
    }
}

/*
Time Complexity:
First loop → O(n)
Second loop → O(n)
Overall → O(n)

Space Complexity:
O(1) → only variables used

Explanation:
- calculate total sum of array
- maintain left sum while traversing
- compare left sum with remaining right sum
*/

/*
Sample Input 1:
1 4 9 3 2

Sample Output 1:
2

Sample Input 2:
1 4 6

Sample Output 2:
-1

Sample Input 3:
1 -1 4

Sample Output 3:
2
*/