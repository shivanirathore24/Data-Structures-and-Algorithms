package graphs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement :
Given an undirected graph G(V,E) and two vertices v1 and v2,
check if there exists any path between them using BFS.
Return true if path exists otherwise false.
*/

public class HasDepth {
    // O(V + E)
    public static boolean hasPath(int adjMatrix[][], int sv, int ev) {
        boolean visited[] = new boolean[adjMatrix.length];
        Queue<Integer> pendingVertices = new LinkedList<>();

        visited[sv] = true;
        pendingVertices.add(sv);

        while(!pendingVertices.isEmpty()) {
            int currentVertex = pendingVertices.poll();
            // Destination found
            if(currentVertex == ev) {
                return true;
            }

            for(int i = 0; i < adjMatrix.length; i++) {
                if(adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                    // i is neighbour of currentVertex
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();  //number of vertices
        int e = s.nextInt();  //number of edges

        int adjMatrix[][] = new int[n][n];

        for(int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }

        int sv = s.nextInt();  //source vertex
        int ev = s.nextInt();  //end vertex
        System.out.println(hasPath(adjMatrix, sv, ev));
    }
}

/*
Time Complexity :
O(V + E)

Space Complexity :
O(V)

Explanation :
We start BFS traversal from source vertex.
If destination vertex is found during traversal,
then path exists otherwise no path exists.
*/

/*
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3

Sample Output 1 :
true


Sample Input 2 :
5 3
0 1
2 3
3 4
0 4

Sample Output 2 :
false
*/