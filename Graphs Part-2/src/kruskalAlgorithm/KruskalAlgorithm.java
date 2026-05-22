package kruskalAlgorithm;
import java.util.Arrays;
import java.util.Scanner;

/*
Problem Statement:
Given an undirected, connected and weighted graph,
find and print the Minimum Spanning Tree (MST)
using Kruskal’s Algorithm.
*/

public class KruskalAlgorithm {
    // O(V)
    private static int findParent(int v, int[] parent) {
        if(v == parent[v]) {
            return v;
        }
        return findParent(parent[v], parent);
    }

    // O(E log E)
    public static Edge[] kruskalAlgorithm(Edge[] edges, int n) {
        // Sort edges according to weight
        Arrays.sort(edges);

        Edge[] mst = new Edge[n - 1];
        int[] parent = new int[n];
        // Initially every vertex is its own parent
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int count = 0;
        int i = 0;
        while(count != n - 1) {
            Edge currentEdge = edges[i++];
            int v1Parent = findParent(currentEdge.v1, parent);
            int v2Parent = findParent(currentEdge.v2, parent);

            // Include edge if cycle is not formed
            if(v1Parent != v2Parent) {
                mst[count] = currentEdge;
                count++;
                parent[v1Parent] = v2Parent;
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();

        Edge[] edges = new Edge[e];
        // Take input edges
        for(int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int weight = s.nextInt();

            edges[i] = new Edge(v1, v2, weight);
        }

        Edge[] mst = kruskalAlgorithm(edges, n);
        // Print MST
        for(int i = 0; i < mst.length; i++) {
            if(mst[i].v1 < mst[i].v2) {
                System.out.println(mst[i].v1 + " " + mst[i].v2 + " " + mst[i].weight);
            } else {
                System.out.println(mst[i].v2 + " " + mst[i].v1 + " " + mst[i].weight);
            }
        }
    }
}

/*
Time Complexity :
O(E log E)
Sorting all edges takes maximum time.

Space Complexity :
O(V + E)
Parent array and edge array are used.

Explanation :
Kruskal’s Algorithm sorts all edges
in increasing order of weight.

It picks the smallest edge which
does not form a cycle.

Union-Find is used to detect cycles.
*/

/*
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8

Sample Output 1 :
1 2 1
0 1 3
0 3 5

Graph Structure :
0 -----3----- 1
|               \
5                1
|                 \
3 --------8------- 2

MST Edges :
1 - 2  (1)
0 - 1  (3)
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