package graphs;
import java.util.ArrayList;
import java.util.Scanner;

/*
Problem Statement:
Given an undirected graph G(V, E) and two vertices v1 and v2,
find and print the path from v1 to v2 using DFS.

Print the path in reverse order.
If no path exists, print nothing.
*/

public class GetPathDFS {
    // O(V + E)
    public static ArrayList<Integer> getPathDFSHelper(int edges[][], int sv, int ev, boolean visited[]) {
        if(sv == ev) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(sv);
            return ans;
        }

        visited[sv] = true;

        for(int i = 0; i < edges.length; i++) {
            if(edges[sv][i] == 1 && !visited[i]) {
                ArrayList<Integer> smallAns = getPathDFSHelper(edges, i, ev, visited);

                if(smallAns != null) {
                    smallAns.add(sv);
                    return smallAns;
                }
            }
        }
        return null;
    }

    // O(V + E)
    public static ArrayList<Integer> getPathDFS(int edges[][], int sv, int ev) {
        boolean visited[] = new boolean[edges.length];
        return getPathDFSHelper(edges, sv, ev, visited);
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

        int sv = s.nextInt();
        int ev = s.nextInt();

        ArrayList<Integer> ans = getPathDFS(edges, sv, ev);
        if(ans != null) {
            for(int elem : ans) {
                System.out.print(elem + " ");
            }
        }
    }
}

/*
Time Complexity :
O(V + E)
DFS visits every vertex and edge at most once.

Space Complexity :
O(V)
Visited array and recursion stack use extra space.

Explanation :
We use DFS to search a path from source vertex to end vertex.
When destination is found, recursion returns the path in reverse order.
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
3 0 1


Sample Input 2 :
6 3
0 1
3 4
4 5
0 5

Sample Output 2 :

*/