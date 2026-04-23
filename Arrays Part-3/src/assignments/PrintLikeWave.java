package assignments;

/*
Problem Statement:
Print the 2D array in wave form (column-wise).
Even column → top to bottom
Odd column → bottom to top
*/

public class PrintLikeWave {
	public static void wavePrint(int mat[][]) {
		int rows = mat.length;

		if (rows == 0) {
			return;
		}

		int cols = mat[0].length;
		for (int j = 0; j < cols; j++) {
			if (j % 2 == 0) {
				// even column → top to bottom
				for (int i = 0; i < rows; i++) {
					System.out.print(mat[i][j] + " ");
				}
			} else {
				// odd column → bottom to top
				for (int i = rows - 1; i >= 0; i--) {
					System.out.print(mat[i][j] + " ");
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] mat = {
				{1, 2, 3, 10},
				{4, 5, 6, 11},
				{7, 8, 9, 12},
				{13,14,15,16}
		};
		wavePrint(mat);
	}
}

/*
Sample Input 1:
1 2 3 4
5 6 7 8
9 10 11 12

Sample Output 1:
1 5 9 10 6 2 3 7 11 12 8 4

Sample Input 2:
1 2 3
4 5 6
7 8 9
10 11 12
13 14 15

Sample Output 2:
1 4 7 10 13 14 11 8 5 2 3 6 9 12 15
*/