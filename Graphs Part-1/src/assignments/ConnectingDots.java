package assignments;
import java.util.Scanner;

/*
Problem Statement:
Given an N x M board containing uppercase English characters,
find whether there exists a cycle of same coloured dots.

A cycle:
1. Contains same characters only.
2. Has length at least 4.
3. Adjacent cells share an edge.
*/

public class ConnectingDots {
    // 4 directions
    static int row[] = {-1, 1, 0, 0};
    static int col[] = {0, 0, -1, 1};

    // O(N * M)
    public static boolean DFS(char board[][], boolean visited[][], int currentX, int currentY,
                              int parentX, int parentY, char color) {
        visited[currentX][currentY] = true;

        for(int i = 0; i < 4; i++) {
            int newX = currentX + row[i];
            int newY = currentY + col[i];

            // Check valid cell
            if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                // Same colour required
                if(board[newX][newY] == color) {
                    // Ignore parent cell
                    if(newX == parentX && newY == parentY) {
                        continue;
                    }

                    // Cycle found
                    if(visited[newX][newY]) {
                        return true;
                    }

                    // Continue DFS
                    if(DFS(board, visited, newX, newY, currentX, currentY, color)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // O(N * M)
    public static boolean hasCycle(char board[][], int n, int m) {
        boolean visited[][] = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    if(DFS(board, visited, i, j, -1, -1, board[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        char board[][] = new char[n][m];
        for(int i = 0; i < n; i++) {
            String str = s.next();
            for(int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        System.out.println(hasCycle(board, n, m));
    }
}

/*
Time Complexity :
O(N * M)
Each cell is visited once.

Space Complexity :
O(N * M)
Visited array and recursion stack.

Explanation :
We perform DFS on cells having same colour.
If during traversal we reach an already visited cell
which is not the parent, then a cycle exists.
*/

/*
Sample Input 1 :
3 4
AAAA
ABCA
AAAA

Sample Output 1 :
true


Sample Input 2 :
3 4
AAAA
ABCA
AADA

Sample Output 2 :
false
*/