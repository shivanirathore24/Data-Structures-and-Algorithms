package assignments;

/*
Problem Statement:
Return all subsets whose sum is equal to K.
*/

public class ReturnSubsetsSumtoK {
    /*
     * Time Complexity : O(2^N)
     * Every element has two recursive choices
     */
    public static int[][] subsetsSumK(int input[], int k) {
        return subsetsSumKHelper(input, 0, k);
    }

    public static int[][] subsetsSumKHelper(int[] input, int startIndex, int k) {
        // base case
        if (startIndex == input.length) {
            if (k == 0) {
                return new int[1][0];
            } else {
                return new int[0][0];
            }
        }

        // exclude current element
        int[][] smallOutput1 = subsetsSumKHelper(input, startIndex + 1, k);

        // include current element
        int[][] smallOutput2 = subsetsSumKHelper(input, startIndex + 1, k - input[startIndex]);

        int index = 0;
        int[][] output = new int[smallOutput1.length + smallOutput2.length][];

        // copy subsets without current element
        for (int i = 0; i < smallOutput1.length; i++) {
            output[index++] = smallOutput1[i];
        }

        // add current element to subsets
        for (int i = 0; i < smallOutput2.length; i++) {
            output[index] = new int[smallOutput2[i].length + 1];
            output[index][0] = input[startIndex];

            for (int j = 0; j < smallOutput2[i].length; j++) {
                output[index][j + 1] = smallOutput2[i][j];
            }
            index++;
        }
        return output;
    }

    public static void main(String[] args) {
        int arr[] = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        int k = 6;

        int output[][] = subsetsSumK(arr, k);

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
O(2^N)
- Every element has two recursive choices

Space Complexity:
O(2^N)
- All subsets are stored

Explanation:
- Generate subsets recursively
- One recursive call excludes current element
- Another recursive call includes current element
- Store only subsets whose sum becomes K
*/

/*
Sample Input 1:
5 12 3 17 1 18 15 3 17
6

Sample Output 1:
3 3
5 1


Sample Input 2:
1 2 3 4
5

Sample Output 2:
2 3
1 4
*/