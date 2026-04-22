package sorting;

public class InsertionSort {
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            // insert ith element in sorted position
            int j = i - 1;
            int temp = arr[i];

            // shift all elements > temp to right
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            // position will be j+1
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 6, 3, 7, 2, 8, 1, 5};
        insertionSort(arr);
        printArray(arr);
    }
}
