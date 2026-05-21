package graphs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Given an undirected graph G(V, E) and two vertices v1 and v2,
find and print the shortest path from v1 to v2 using BFS.

Print the path in reverse order.
If no path exists, print nothing.
*/

public class GetPathBFS {
    // O(V + E)
    public static ArrayList<Integer> getPathBFSHelper(int edges[][], int sv, int ev, boolean visited[]) {
        int n = edges.length;

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(sv);
        visited[sv] = true;

        while(!queue.isEmpty()) {
            int front = queue.remove();

            for(int i = 0; i < n; i++) {
                if(edges[front][i] == 1 && !visited[i]) {
                    map.put(i, front);
                    queue.add(i);

                    visited[i] = true;

                    // destination found
                    if(i == ev) {
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(ev);

                        int value = map.get(ev);
                        while(value != sv) {
                            ans.add(value);
                            value = map.get(value);
                        }

                        ans.add(value);
                        return ans;
                    }
                }
            }
        }
        return null;
    }

    // O(V + E)
    public static ArrayList<Integer> getPathBFS(int edges[][], int sv, int ev) {
        boolean visited[] = new boolean[edges.length];

        // source and destination same
        if(sv == ev) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(sv);
            return ans;
        }

        return getPathBFSHelper(edges, sv, ev, visited);
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

        ArrayList<Integer> ans = getPathBFS(edges, sv, ev);
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
BFS visits every vertex and edge at most once.

Space Complexity :
O(V)
Queue, map, and visited array use extra space.


Explanation :
We use BFS traversal to find the shortest path between source
and destination. Parent mapping helps reconstruct the path
in reverse order from destination to source.
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