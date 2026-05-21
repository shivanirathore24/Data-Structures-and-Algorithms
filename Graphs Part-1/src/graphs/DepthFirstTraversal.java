package graphs;
import java.util.Scanner;

/*
Problem Statement :
Given an undirected graph, print its Depth First Traversal (DFS).
If graph is disconnected, then print DFS for all components.
*/

public class DepthFirstTraversal {
	// O(V + E)
	public static void dfTraversal(int adjMatrix[][]) {
		boolean visited[] = new boolean[adjMatrix.length];

		for(int i = 0; i < adjMatrix.length; i++) {
			if(visited[i] == false) {
				dfTraversal(adjMatrix, i, visited);
			}
		}
	}

	// O(V)
	public static void dfTraversal(int adjMatrix[][], int currentVertex, boolean visited[]) {
		visited[currentVertex] = true;
		System.out.print(currentVertex + " ");

		for(int i = 0; i < adjMatrix.length; i++) {
			if(adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
				// i is neighbour of currentVertex
				dfTraversal(adjMatrix, i, visited);
			}
		}
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

		System.out.println("Adjacency Matrix:");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Depth First Traversal:");
		dfTraversal(adjMatrix);
	}
}

/*
Time Complexity :
O(V + E)

Space Complexity :
O(V)

Explanation :
DFS visits a vertex first and then recursively visits all
its unvisited neighbouring vertices. For disconnected graphs,
DFS is called for every unvisited vertex.
*/

/*
Sample Input 1 :
5 4
0 1
0 2
1 3
2 4

Sample Output 1 :
Adjacency Matrix:
0 1 1 0 0
1 0 0 1 0
1 0 0 0 1
0 1 0 0 0
0 0 1 0 0

Depth First Traversal:
0 1 3 2 4


Sample Input 2 :
7 4
0 1
2 3
4 5
5 6

Sample Output 2 :
Adjacency Matrix:
0 1 0 0 0 0 0
1 0 0 0 0 0 0
0 0 0 1 0 0 0
0 0 1 0 0 0 0
0 0 0 0 0 1 0
0 0 0 0 1 0 1
0 0 0 0 0 1 0

Depth First Traversal:
0 1 2 3 4 5 6
*/