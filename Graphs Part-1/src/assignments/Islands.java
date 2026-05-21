package assignments;
import java.util.Scanner;

/*
Problem Statement:
Given V islands and E connections between islands,
count the number of connected groups of islands.
*/

public class Islands {
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
    public static int numConnected(int edges[][], int n) {
        boolean visited[] = new boolean[n];

        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                DFS(edges, i, visited);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();  //number of islands
        int e = s.nextInt();  //number of connections

        int edges[][] = new int[n][n];
        for(int i = 0; i < e; i++) {
            int fv = s.nextInt();
            int sv = s.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        System.out.println(numConnected(edges, n));
    }
}

/*
Time Complexity :
O(V + E)
DFS traverses all vertices and edges once.

Space Complexity :
O(V)
Visited array and recursion stack use extra space.

Explanation :
We traverse every island using DFS.
Whenever we find an unvisited island,
it means a new connected group is found.
So we increase the count.
*/

/*
Sample Input 1 :
5 8
0 1
0 4
1 2
2 0
2 4
3 0
3 2
4 3

Sample Output 1 :
1


Sample Input 2 :
6 3
0 1
2 3
4 5

Sample Output 2 :
3
*/