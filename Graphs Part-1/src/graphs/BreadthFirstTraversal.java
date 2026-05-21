package graphs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Given an undirected graph, print the Breadth First Traversal (BFS).

The graph can be disconnected, so BFS traversal should be
printed for all connected components.
*/

public class BreadthFirstTraversal {
	// O(V + E)
	public static void bfTraversal(int adjMatrix[][]) {
		Queue<Integer> pendingVertices = new LinkedList<>();
		boolean visited[] = new boolean[adjMatrix.length];

		for(int j = 0; j < adjMatrix.length; j++) {
			if(!visited[j]) {
				visited[j] = true;
				pendingVertices.add(j);

				while(!pendingVertices.isEmpty()) {
					int currentVertex = pendingVertices.poll();
					System.out.print(currentVertex + " ");

					for(int i = 0; i < adjMatrix.length; i++) {
						if(adjMatrix[currentVertex][i] == 1 && !visited[i]) {
							// i is neighbour of currentVertex
							pendingVertices.add(i);
							visited[i] = true;
						}
					}
				}
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

		System.out.println("Breadth First Traversal:");
		bfTraversal(adjMatrix);
	}
}

/*
Time Complexity :
O(V + E)
Each vertex and edge is visited once during BFS traversal.

Space Complexity :
O(V)
Visited array and queue take extra space.

Explanation :
BFS visits all neighbours level by level using a queue.
If the graph is disconnected, BFS starts again from
every unvisited vertex.
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

Breadth First Traversal:
0 1 2 3 4


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

Breadth First Traversal:
0 1 2 3 4 5 6
*/