package assignments;
import java.util.Scanner;

/*
Problem Statement:
Given an N x N cake containing only '0' and '1',
find the size of the largest connected piece of '1's.

Cells are connected only in 4 directions:
up, down, left and right.
*/

public class LargestPiece {
    // 4 directions
    static int row[] = {-1, 1, 0, 0};
    static int col[] = {0, 0, -1, 1};

    // O(N * N)
    public static int DFS(String[] edge, boolean visited[][], int currentX, int currentY, int n) {
        visited[currentX][currentY] = true;

        int count = 1;
        for(int i = 0; i < 4; i++) {
            int newX = currentX + row[i];
            int newY = currentY + col[i];

            // Check valid cell
            if(newX >= 0 && newX < n
                    && newY >= 0 && newY < n) {

                // Visit connected '1'
                if(edge[newX].charAt(newY) == '1' && !visited[newX][newY]) {
                    count += DFS(edge, visited, newX, newY, n);
                }
            }
        }
        return count;
    }

    // O(N * N)
    public static int largestPiece(String[] edge, int n) {
        boolean visited[][] = new boolean[n][n];

        int maxPiece = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // Start DFS from unvisited '1'
                if(edge[i].charAt(j) == '1' && !visited[i][j]) {

                    int currentPiece = DFS(edge, visited, i, j, n);
                    maxPiece = Math.max(maxPiece, currentPiece);
                }
            }
        }
        return maxPiece;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        String edge[] = new String[n];
        for(int i = 0; i < n; i++) {
            edge[i] = s.next();
        }

        System.out.println(largestPiece(edge, n));
    }
}

/*
Time Complexity :
O(N * N)
Each cell is visited only once.

Space Complexity :
O(N * N)
Visited array and recursion stack.


Explanation :
We use DFS to count connected '1's.
For every unvisited '1', calculate its connected component size
and update the maximum answer.
*/

/*
Sample Input 1 :
2
11
01

Sample Output 1 :
3


Sample Input 2 :
4
1100
1110
0110
0001

Sample Output 2 :
7
*/