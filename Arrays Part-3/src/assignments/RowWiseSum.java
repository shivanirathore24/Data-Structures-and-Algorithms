package assignments;

/*
Problem Statement:
Given a 2D array, print the sum of each row in a single line.
*/

public class RowWiseSum {
    public static void rowWiseSum(int[][] mat) {
        int rows = mat.length;
        if (rows == 0) {
            return;
        }
        int cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += mat[i][j];
            }
            System.out.print(sum + " ");
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        rowWiseSum(mat);
    }
}

/*
Sample Input 1:
1 2
3 4
5 6
7 8

Sample Output 1:
3 7 11 15

Sample Input 2:
4 5 3 2 6
7 5 3 8 9

Sample Output 2:
20 32
*/