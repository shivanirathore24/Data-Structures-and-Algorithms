package assignments;
import java.util.Scanner;

/*
Problem Statement:
Given an undirected graph with N vertices and M edges,
count the number of distinct 3-cycles present in the graph.

A 3-cycle means:
If edges (i,j), (j,k) and (k,i) exist.
*/

public class ThreeCycle {
    // O(N^3)
    public static int countThreeCycles(boolean[][] graph, int n) {
        int cycleCount = 0;
        // Pick 3 different vertices
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    // Check triangle
                    if(graph[i][j] && graph[j][k] && graph[k][i]) {
                        cycleCount++;
                    }
                }
            }
        }
        return cycleCount;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        boolean[][] graph = new boolean[n][n];
        // Take edges
        for(int i = 0; i < m; i++) {
            int u = s.nextInt();
            int v = s.nextInt();
            graph[u][v] = true;
            graph[v][u] = true;
        }

        System.out.println(countThreeCycles(graph, n));
    }
}

/*
Time Complexity :
O(N^3)
Checking every combination of 3 vertices.

Space Complexity :
O(N^2)
Adjacency matrix is used.

Explanation :
We select every possible triplet of vertices.
If all three edges exist among them,
then they form one distinct 3-cycle.
*/

/*
Sample Input 1 :
3 3
0 1
1 2
2 0

Sample Output 1 :
1


Graph Structure :
0 ----- 1
 \     /
   \ /
    2


Sample Input 2 :
4 5
0 1
1 2
2 0
0 3
2 3

Sample Output 2 :
2


Graph Structure :
0 ----- 1
| \     |
|   \   |
3 ----- 2

3-cycles:
(0,1,2)
(0,2,3)
*/