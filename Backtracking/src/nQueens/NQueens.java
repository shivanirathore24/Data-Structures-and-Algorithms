package nQueens;

/*
Problem Statement:
Print all possible ways to place N Queens safely.
*/

public class NQueens {
    // O(N!)
    public static void placeNQueens(int n) {
        int board[][] = new int[n][n];
        placeQueens(board, 0, n);
    }

    // O(N!)
    public static void placeQueens(int[][] board, int row, int n) {
        // all queens placed
        if(row == n) {
            // print board
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
            return;
        }

        // try placing queen in every column
        for(int col = 0; col < n; col++) {
            if(isSafe(board, row, col, n)) {
                // place queen
                board[row][col] = 1;
                placeQueens(board, row + 1, n);
                // backtrack
                board[row][col] = 0;
            }
        }
    }

    // O(n)
    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // check vertical
        for(int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 1) {
                return false;
            }
        }

        // check left diagonal
        for(int i = row - 1, j = col - 1;
            i >= 0 && j >= 0;
            i--, j--) {

            if(board[i][j] == 1) {
                return false;
            }
        }

        // check right diagonal
        for(int i = row - 1, j = col + 1;
            i >= 0 && j < n;
            i--, j++) {

            if(board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        placeNQueens(n);
    }
}

/*
Time Complexity:
O(N!)
- Try placing queens in every possible way

Space Complexity:
O(N*N)
- Chess board storage

Explanation:
- Place one queen in every row
- Check column and diagonals for safety
- Backtrack if placement becomes invalid
- Print board when all queens are placed
*/

/*
Sample Input 1:
4

Sample Output 1:
0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0
0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0


Sample Input 2:
1

Sample Output 2:
1


Sample Input 3:
2

Sample Output 3:
No Possible Configuration
*/