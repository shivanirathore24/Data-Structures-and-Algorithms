package primsAlgorithm;

import java.util.Scanner;

/*
Problem Statement:
Given an undirected, connected and weighted graph,
find and print the Minimum Spanning Tree (MST)
using Prim’s Algorithm.
*/

public class PrimsAlgorithm {
    // O(V)
    private static int findMinVertex(boolean[] visited, int[] weight) {
        int minVertex = -1;

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    // O(V^2)
    public static void prims(int[][] adjMatrix) {
        int n = adjMatrix.length;
        boolean[] visited = new boolean[n];

        int[] parent = new int[n];
        int[] weight = new int[n];

        // Source vertex = 0
        parent[0] = -1;
        weight[0] = 0;

        // Initialize weights
        for (int i = 1; i < n; i++) {
            weight[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n - 1; i++) {
            int minVertex = findMinVertex(visited, weight);
            visited[minVertex] = true;

            // Explore neighbors
            for (int j = 0; j < n; j++) {
                if (adjMatrix[minVertex][j] != 0 && !visited[j]) {
                    // Update smaller weight
                    if (weight[j] > adjMatrix[minVertex][j]) {
                        weight[j] = adjMatrix[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }
        }

        // Print MST
        for (int i = 1; i < n; i++) {
            if (i < parent[i]) {
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            } else {
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        int e = s.nextInt();

        int[][] adjMatrix = new int[v][v];
        // Take input edges
        for (int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int weight = s.nextInt();

            adjMatrix[v1][v2] = weight;
            adjMatrix[v2][v1] = weight;
        }
        prims(adjMatrix);
    }
}

/*
Time Complexity :
O(V^2)
For every vertex, minimum weight vertex is searched.

Space Complexity :
O(V^2)
Adjacency matrix is used.

Explanation :
Prim’s Algorithm starts from vertex 0.

At every step, it selects the minimum weight edge
which connects a visited vertex
to an unvisited vertex.

This process continues until
all vertices become part of MST.
*/

/*
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8

Sample Output 1 :
0 1 3
1 2 1
0 3 5

Graph Structure :
0 -----3----- 1
|               \
5                1
|                 \
3 --------8------- 2

MST Edges :
0 - 1  (3)
1 - 2  (1)
0 - 3  (5)


Sample Input 2 :
5 7
0 1 2
0 3 6
1 2 3
1 3 8
1 4 5
2 4 7
3 4 9

Sample Output 2 :
0 1 2
1 2 3
1 4 5
0 3 6

Graph Structure :
        0
      /   \
    2/     \6
    /       \
   1 ----3--- 2
    \         /
    5\       /7
      \     /
        4
         \
          \9
           \
            3

MST Edges :
0 - 1  (2)
1 - 2  (3)
1 - 4  (5)
0 - 3  (6)
*/