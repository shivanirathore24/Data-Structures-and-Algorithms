package graphs;
import java.util.Scanner;

/*
Problem Statement:
Given an undirected graph G(V, E),
check whether the graph is connected or not.
*/

public class IsConnected {
    // O(V + E)
    public static void DFS(int edges[][], int sv, boolean visited[]) {
        visited[sv] = true;

        for(int i = 0; i < edges.length; i++) {
            if(edges[sv][i] == 1 && !visited[i]) {
                DFS(edges, i, visited);
            }
        }
    }

    // O(V + E)
    public static boolean isConnected(int edges[][]) {
        // empty graph is connected
        if(edges.length == 0) {
            return true;
        }

        boolean visited[] = new boolean[edges.length];

        DFS(edges, 0, visited);
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();  //number of vertices
        int e = s.nextInt();  //number of edges

        int edges[][] = new int[n][n];

        for(int i = 0; i < e; i++) {
            int fv = s.nextInt();
            int sv = s.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        System.out.println(isConnected(edges));
    }
}

/*
Time Complexity :
O(V + E)
DFS visits every vertex and edge once.

Space Complexity :
O(V)
Visited array and recursion stack use extra space.

Explanation :
We start DFS traversal from vertex 0.
If all vertices become visited, then graph is connected,
otherwise graph is disconnected.
*/

/*
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3

Sample Output 1 :
true


Sample Input 2 :
4 3
0 1
1 3
0 3

Sample Output 2 :
false
*/