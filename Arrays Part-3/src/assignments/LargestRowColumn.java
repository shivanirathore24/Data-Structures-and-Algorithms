package assignments;

/*
Problem Statement:
You are given a 2D array. Find the row or column with the maximum sum.
If tie → choose first. If row and column tie → choose row.
*/

public class LargestRowColumn {
    public static void findLargest(int mat[][]) {
        int rows = mat.length;
        int largestSum = Integer.MIN_VALUE;
        boolean isRow = true;
        int idx = 0;

        if (rows == 0) {
            System.out.println("row " + idx + " " + largestSum);
            return;
        }

        int cols = mat[0].length;
        // check all rows
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) {
                rowSum += mat[i][j];
            }
            // update if larger sum found
            if (rowSum > largestSum) {
                largestSum = rowSum;
                idx = i;
            }
        }

        // check all columns
        for (int j = 0; j < cols; j++) {
            int colSum = 0;
            for (int i = 0; i < rows; i++) {
                colSum += mat[i][j];
            }
            // update if larger sum found
            if (colSum > largestSum) {
                largestSum = colSum;
                idx = j;
                isRow = false;
            }
        }
        if (isRow) {
            System.out.println("row " + idx + " " + largestSum);
        } else {
            System.out.println("column " + idx + " " + largestSum);
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4}, {4, 2, 1, 1}, {2, 3, 4, 5}};
        findLargest(mat);
    }
}

/*
Sample Input 1:
6 9
8 5
9 2

Sample Output 1:
column 0 23

Sample Input 2:
6 9 8 5
9 2 4 1
8 3 9 3
8 7 8 6

Sample Output 2:
column 0 31
*/