package assignments;

/*
Problem Statement:
Print all subsets of an array using recursion.
*/

public class PrintSubsetsOfArray {
    // O(2^n)
    public static void printSubsetsArray(int input[]) {
        int output[] = new int[0];
        printSubsetsArrayHelper(input, 0, output);
    }

    // O(2^n)
    public static void printSubsetsArrayHelper(int input[], int beginIndex, int[] output) {
        // base case
        if (beginIndex == input.length) {
            // print subset
            for (int i : output) {
                System.out.print(i + " ");
            }
            System.out.println();
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
        printSubsetsArrayHelper(input, beginIndex + 1, output);

        // include current element
        printSubsetsArrayHelper(input, beginIndex + 1, newOutput);
    }

    public static void main(String[] args) {
        int arr[] = {15, 20, 12};
        printSubsetsArray(arr);
    }
}

/*
Time Complexity:
O(2^n)
- Every element has two recursive choices

Space Complexity:
O(n)
- Recursive stack stores function calls

Explanation:
- For every element:
  include it or exclude it
- Recursively generate all subsets
- Print subsets when array ends
*/

/*
Sample Input 1:
15 20 12

Sample Output 1:

12
20
20 12
15
15 12
15 20
15 20 12


Sample Input 2:
1 2

Sample Output 2:

2
1
1 2
*/