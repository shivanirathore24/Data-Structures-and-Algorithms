package sorting;

public class BubbleSort {
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // total passes = n-1
        for (int i = 0; i < n - 1; i++) {

            // compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // swap if left > right
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 4, 3, 9, 2, 6, 5};
        bubbleSort(arr);
        printArray(arr);
    }
}
