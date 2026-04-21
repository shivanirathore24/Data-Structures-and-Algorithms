package assignments;

/*
Problem Statement:
You have been given an integer array/list(ARR) of size N where N = [2M + 1].
M numbers appear twice and one number appears once.
Find and return the unique number.
*/

public class FindUnique1 {
    public static int findUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j;

            for (j = 0; j < arr.length; j++) {
                if (i != j) {
                    if (arr[i] == arr[j]) {
                        break;
                    }
                }
            }

            if (j == arr.length) {
                return arr[i];
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] arr = {9, 9, 6, 5, 8, 8, 5};
        System.out.println(findUnique(arr));
    }
}

/*
Sample Input 1:
2 3 1 6 3 6 2

Sample Output 1:
1

Sample Input 2:
2 4 7 2 7

Sample Output 2:
4
*/