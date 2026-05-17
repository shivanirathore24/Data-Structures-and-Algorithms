package assignments;

/*
Problem Statement:
Return all subsets of an array using recursion.
*/

public class ReturnSubsetOfArray {
    // O(2^n)
    public static int[][] subsetsArray(int[] input) {
        return subsetsArrayHelper(input, 0);
    }

    // O(2^n)
    public static int[][] subsetsArrayHelper(int[] input, int startIndex) {
        // base case
        if (startIndex == input.length) {
            int[][] output = new int[1][0];
            return output;
        }

        int[][] smallerOutput = subsetsArrayHelper(input, startIndex + 1);
        int[][] output = new int[2 * smallerOutput.length][];

        int k = 0;
        // subsets without current element
        for (int i = 0; i < smallerOutput.length; i++) {
            output[k] = new int[smallerOutput[i].length];
            for (int j = 0; j < smallerOutput[i].length; j++) {
                output[k][j] = smallerOutput[i][j];
            }
            k++;
        }

        // subsets with current element
        for (int i = 0; i < smallerOutput.length; i++) {
            output[k] = new int[smallerOutput[i].length + 1];
            output[k][0] = input[startIndex];

            for (int j = 1; j <= smallerOutput[i].length; j++) {
                output[k][j] = smallerOutput[i][j - 1];
            }
            k++;
        }
        return output;
    }

    public static void main(String[] args) {
        int arr[] = {15, 20, 12};
        int output[][] = subsetsArray(arr);

        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
Time Complexity:
O(2^n)
- Every element has two choices

Space Complexity:
O(2^n)
- All subsets are stored

Explanation:
- For every element:
  include it or exclude it
- Combine smaller recursive subsets
- Total subsets become 2^n
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