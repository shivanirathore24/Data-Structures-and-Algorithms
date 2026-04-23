package assignments;

/*
Problem Statement:
Print the 2D array in spiral form.
Order:
top row → right column → bottom row → left column
*/

public class PrintSpiral {
    public static void spiralPrint(int matrix[][]) {
        int rows = matrix.length;
        if (rows == 0) {
            return;
        }
        int cols = matrix[0].length;

        int rowStart = 0;
        int colStart = 0;

        int count = 0;
        int total = rows * cols;

        while (count < total) {
            // top row (left → right)
            for (int i = colStart; i < cols && count < total; i++) {
                System.out.print(matrix[rowStart][i] + " ");
                count++;
            }
            rowStart++;

            // right column (top → bottom)
            for (int i = rowStart; i < rows && count < total; i++) {
                System.out.print(matrix[i][cols - 1] + " ");
                count++;
            }
            cols--;

            // bottom row (right → left)
            for (int i = cols - 1; i >= colStart && count < total; i--) {
                System.out.print(matrix[rows - 1][i] + " ");
                count++;
            }
            rows--;

            // left column (bottom → top)
            for (int i = rows - 1; i >= rowStart && count < total; i--) {
                System.out.print(matrix[i][colStart] + " ");
                count++;
            }
            colStart++;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        spiralPrint(matrix);
    }
}

/*
Sample Input 1:
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

Sample Output 1:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

Sample Input 2:
1 2 3
4 5 6
7 8 9

Sample Output 2:
1 2 3 6 9 8 7 4 5
*/
