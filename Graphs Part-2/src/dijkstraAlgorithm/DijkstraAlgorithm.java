package dijkstraAlgorithm;
import java.util.Scanner;

/*
Problem Statement:
Given an undirected, connected and weighted graph,
find the shortest distance from source vertex 0
to all other vertices using Dijkstra’s Algorithm.
*/

public class DijkstraAlgorithm {
    // O(V)
    private static int findMinVertex(boolean[] visited, int[] distance) {
        int minVertex = -1;

        for(int i = 0; i < visited.length; i++) {
            if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    // O(V^2)
    public static void dijkstra(int[][] adjMatrix) {
        int n = adjMatrix.length;
        boolean[] visited = new boolean[n];

        int[] distance = new int[n];
        // Source vertex distance = 0
        distance[0] = 0;

        // Initialize distances
        for(int i = 1; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < n - 1; i++) {
            int minVertex = findMinVertex(visited, distance);
            visited[minVertex] = true;

            // Explore neighbours
            for(int j = 0; j < n; j++) {
                if(adjMatrix[minVertex][j] > 0 && !visited[j]) {
                    // Calculate new distance
                    int newDistance = distance[minVertex] + adjMatrix[minVertex][j];

                    // Update smaller distance
                    if(newDistance < distance[j]) {
                        distance[j] = newDistance;
                    }
                }
            }
        }

        // Print shortest distances
        for(int i = 0; i < n; i++) {
            System.out.println(i + " " + distance[i]);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();

        int[][] adjMatrix = new int[n][n];
        // Take input edges
        for(int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int weight = s.nextInt();

            adjMatrix[v1][v2] = weight;
            adjMatrix[v2][v1] = weight;
        }
        dijkstra(adjMatrix);
    }
}

/*
Time Complexity :
O(V^2)
For every vertex, minimum distance vertex is searched.

Space Complexity :
O(V^2)
Adjacency matrix is used.

Explanation :
Dijkstra’s Algorithm finds shortest distance
from source vertex 0 to all vertices.

At every step, the unvisited vertex
with minimum distance is selected.

Then distances of all its neighbours
are updated.
*/

/*
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8

Sample Output 1 :
0 0
1 3
2 4
3 5

Graph Structure :
0 -----3----- 1
|               \
5                1
|                 \
3 --------8------- 2

Shortest Distances from 0 :
0 -> 0 = 0
0 -> 1 = 3
0 -> 2 = 4
0 -> 3 = 5


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
0 0
1 2
2 5
3 6
4 7

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

Shortest Distances from 0 :
0 -> 0 = 0
0 -> 1 = 2
0 -> 2 = 5
0 -> 3 = 6
0 -> 4 = 7
*/