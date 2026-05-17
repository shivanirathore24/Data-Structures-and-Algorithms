package assignments;

/*
Problem Statement:
Print all subsets whose sum is equal to K.
*/

public class PrintSubsetsSumToK {
    // O(2^n)
    public static void printSubsetsSumToK(int input[], int k) {
        int[] output = new int[0];
        printSubsetsSumToKHelper(input, 0, output, k);
    }

    // O(2^n)
    public static void printSubsetsSumToKHelper(int[] input, int beginIndex, int[] output, int k) {
        // base case
        if (input.length == beginIndex) {
            if (k == 0) {
                for (int i : output) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            return;
        }

        int[] newOutput = new int[output.length + 1];

        int i = 0;
        // copy old subset
        for (; i < output.length; i++) {
            newOutput[i] = output[i];
        }

        // include current element
        newOutput[i] = input[beginIndex];

        // exclude current element
        printSubsetsSumToKHelper(input, beginIndex + 1, output, k);

        // include current element
        printSubsetsSumToKHelper(input, beginIndex + 1, newOutput, k - input[beginIndex]);
    }

    public static void main(String[] args) {
        int arr[] = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        int k = 6;
        printSubsetsSumToK(arr, k);
    }
}

/*
Time Complexity:
O(2^n)
- Every element has two choices

Space Complexity:
O(n)
- Recursive stack stores function calls

Explanation:
- For every element:
  include it or exclude it
- If subset sum becomes K,
  print that subset
*/

/*
Sample Input 1:
5 12 3 17 1 18 15 3 17
6

Sample Output 1:
3 3
5 1


Sample Input 2:
1 2 3 4 5
5

Sample Output 2:
5
2 3
1 4
*/