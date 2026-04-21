package assignments;

/*
Problem Statement:
You have been given an integer array/list(ARR) of size N where N = [2M + 1].
M numbers appear twice and one number appears once.
Find and return the unique number.
*/

public class FindUnique2 {
    public static int findUnique(int[] arr) {
        int val = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count == 1) {
                val = arr[i];
                break;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        int[] arr = {6, 6, 1, 5, 8, 8, 5};
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