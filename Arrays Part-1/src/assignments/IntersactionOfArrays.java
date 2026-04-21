package assignments;

/*
Problem Statement:
You are given two arrays. Print their intersection.
If a number appears in both arrays, print it as many times as it appears in both.
Order should follow the first array.
*/

public class IntersactionOfArrays {
    public static void intersectionOfArray(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.print(arr2[j] + " ");
                    arr2[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] = {2, 6, 2, 3, 8, 2};
        int arr2[] = {3, 2, 2};
        intersectionOfArray(arr1, arr2);
    }
}

/*
Sample Input 1:
arr1 = 2 6 8 5 4 3
arr2 = 2 3 4 7

Sample Output 1:
2 4 3

Sample Input 2:
arr1 = 2 6 1 2
arr2 = 1 2 3 4 2

Sample Output 2:
2 1 2
*/