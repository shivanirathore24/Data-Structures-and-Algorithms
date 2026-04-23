package twoDArrrays;

public class JaggedArray {
    public static void main(String[] args) {
        int[][] arr2 = new int[3][5];
        System.out.println(arr2[0][0]);  // default value = 0

        int[][] arr1 = new int[4][];
        System.out.println(arr1);        // reference
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);  // each row = null
        }
        // System.out.println(arr1[0][0]);  // NullPointerException (row not initialized)

        int[][] arr = new int[4][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[5];  // each row size = 5
        }

        // jagged array - columns vary
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 2];  // row size changes
        }

        // print array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}