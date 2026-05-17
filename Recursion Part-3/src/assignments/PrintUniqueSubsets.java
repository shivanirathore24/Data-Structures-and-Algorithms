package assignments;

/*
Problem Statement:
Print all unique subsets of a sorted array.
*/

public class PrintUniqueSubsets {
    // O(k * 2^n)
    public static void printSubsets(int input[]) {
        int output[] = new int[0];
        printSubsetsHelper(input, 0, output);
    }

    // O(k * 2^n)
    public static void printSubsetsHelper(int input[], int beginIndex, int[] output) {
        // print current subset
        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();

        // generate subsets
        for (int i = beginIndex; i < input.length; i++) {
            // skip duplicate elements
            if (i > beginIndex && input[i] == input[i - 1]) {
                continue;
            }

            int[] newOutput = new int[output.length + 1];

            int k = 0;
            // copy old subset
            for (; k < output.length; k++) {
                newOutput[k] = output[k];
            }

            // include current element
            newOutput[k] = input[i];
            printSubsetsHelper(input, i + 1, newOutput);
        }
    }

    public static void main(String[] args) {
        int arr1[] = {12, 15, 20};
        printSubsets(arr1);

        int arr2[] = {1, 1, 2};
        printSubsets(arr2);
    }
}

/*
Time Complexity:
O(k * 2^n)
- Every subset is generated recursively

Space Complexity:
O(k * 2^n)
- Subsets and recursive stack are stored

Explanation:
- Generate subsets recursively
- Skip duplicate elements
- Include current element in subset
- Print only unique subsets
*/

/*
Sample Input 1:
12 15 20

Sample Output 1:

12
12 15
12 15 20
12 20
15
15 20
20


Sample Input 2:
1 1 2

Sample Output 2:

1
1 1
1 1 2
1 2
2
*/