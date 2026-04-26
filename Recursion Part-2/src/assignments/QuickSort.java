package assignments;

/*
Problem Statement:
Given start and end indices, sort the array using Quick Sort recursively (in-place).
*/

public class QuickSort {
    public static void quickSort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    public static void quickSort(int[] input, int startIndex, int endIndex) {
        // base case
        if (startIndex >= endIndex) {
            return;
        }

        // partition
        int pivotIndex = partition(input, startIndex, endIndex);

        // recursive calls
        quickSort(input, startIndex, pivotIndex - 1);
        quickSort(input, pivotIndex + 1, endIndex);
    }

    public static int partition(int input[], int startIndex, int endIndex) {
        int pivotElement = input[startIndex];
        int smallerNumCount = 0;

        // count elements smaller than pivot
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (input[i] < pivotElement) {
                smallerNumCount++;
            }
        }

        // place pivot at correct position
        int pivotIndex = startIndex + smallerNumCount;

        int temp = input[pivotIndex];
        input[pivotIndex] = input[startIndex];
        input[startIndex] = temp;

        // rearrange elements
        int i = startIndex;
        int j = endIndex;
        while (i < pivotIndex && j > pivotIndex) {
            if (input[i] < pivotElement) {
                i++;
            } else if (input[j] >= pivotElement) {
                j--;
            } else {
                temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }
        }
        return pivotIndex;
    }

    public static void main(String[] args) {
        int input[] = {10, 5, 1, 9, 8, 6, 12, 11, 7};
        quickSort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}

/*
Time Complexity:
Average Case: O(n log n)
Worst Case: O(n^2)
- Depends on pivot selection
- Balanced partition → log n levels

Space Complexity:
O(log n)
- Recursion stack (average case)

Explanation:
- choose first element as pivot
- count elements smaller than pivot
- place pivot at correct position
- rearrange elements around pivot
- recursively sort left and right parts
*/

/*
Sample Input 1:
2 6 8 5 4 3

Sample Output 1:
2 3 4 5 6 8

Sample Input 2:
1 2 3 5 7

Sample Output 2:
1 2 3 5 7
*/