package assignments;

/*
Problem Statement:
Given an array and a number X, find the index of X using Linear Search.
Return the first occurrence index, or -1 if not found.
*/

public class LinearSearch {
    public static int linearSearch(int arr[], int x) {
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 6, 7, 8, 3, 9, 5};
        int arr2[] = {4, 6, 8};
        int x = 3;
        System.out.println(linearSearch(arr1, x));
        System.out.println(linearSearch(arr2, x));
    }
}

/*
Sample Input 1:
arr = 2 13 4 1 3 6 28
x = 3

Sample Output 1:
4

Sample Input 2:
arr = 2 13 4 1 3 6 28
x = 9

Sample Output 2:
-1
*/