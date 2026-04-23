package assignments;

/*
Problem Statement:
Given a square matrix, find the sum of boundary elements and both diagonals.
Do not count any element more than once.
*/

public class BoundaryDiagonalSum {
	public static void totalSum(int[][] mat) {
		int n = mat.length;
		if (n == 0) {
			System.out.println(0);
			return;
		}

		int totalSum = getBoundarySum(mat, n) + getDiagonalSum(mat, n);

		// remove center if counted twice (odd n)
		if (n % 2 != 0) {
			totalSum -= mat[n / 2][n / 2];
		}
		System.out.println(totalSum);
	}

	public static int getBoundarySum(int[][] mat, int n) {
		int sum = 0;

		// top and bottom rows
		for (int i = 0; i < n; i++) {
			sum += mat[0][i];
			sum += mat[n - 1][i];
		}

		// left and right columns
		for (int i = 1; i < n - 1; i++) {
			sum += mat[i][0];
			sum += mat[i][n - 1];
		}
		return sum;
	}

	public static int getDiagonalSum(int[][] mat, int n) {
		int sum = 0;
		// both diagonals (excluding corners already counted)
		for (int i = 1; i < n - 1; i++) {
			sum += mat[i][i];
			sum += mat[i][n - i - 1];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[][] mat = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		totalSum(mat);
	}
}

/*
Sample Input 1:
1 2 3
4 5 6
7 8 9

Sample Output 1:
45

Sample Input 2:
1 2 3 10
4 5 6 11
7 8 9 12
13 14 15 16

Sample Output 2:
136
*/