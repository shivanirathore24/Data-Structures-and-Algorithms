package assignments;

/*
Problem Statement:
You are given an array containing only 0s and 1s.
Sort the array in one traversal without using extra space.
*/

public class Sort01 {

    public static void sortZeroesAndOne(int[] arr) {
        int i = 0;
        int j = 0;

        while (i < arr.length) {
            if (arr[i] == 1) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 0, 1, 1, 0, 1, 1};
        sortZeroesAndOne(arr);
        printArray(arr);
    }
}

/*
Sample Input 1:
0 1 1 0 1 0 1

Sample Output 1:
0 0 0 1 1 1 1

Sample Input 2:
0 1 0 1 0

Sample Output 2:
0 0 0 1 1
*/