package ratInMaze;

/*
Problem Statement:
Check whether path exists in maze or not.
*/

public class RatInMaze1 {
	// O(4^(n*n))
	public static boolean ratInMaze(int[][] maze) {
		int n = maze.length;
		int path[][] = new int[n][n];
		return solveMaze(maze, 0, 0, path);
	}

	// O(4^(n*n))
	public static boolean solveMaze(int[][] maze, int i, int j, int[][] path) {
		int n = maze.length;

		// invalid cell
		if(i < 0 || i >= n ||
				j < 0 || j >= n ||
				maze[i][j] == 0 ||
				path[i][j] == 1) {
			return false;
		}

		// include current cell
		path[i][j] = 1;

		// destination reached
		if(i == n - 1 && j == n - 1) {
			return true;
		}

		// top
		if(solveMaze(maze, i - 1, j, path)) {
			return true;
		}

		// right
		if(solveMaze(maze, i, j + 1, path)) {
			return true;
		}

		// down
		if(solveMaze(maze, i + 1, j, path)) {
			return true;
		}

		// left
		if(solveMaze(maze, i, j - 1, path)) {
			return true;
		}

		// backtrack
		path[i][j] = 0;
		return false;
	}

	public static void main(String[] args) {
		int maze[][] = {
				{1, 1, 0},
				{1, 1, 0},
				{1, 1, 1}
		};

		// int maze[][] = {
		//         {1, 1, 0},
		//         {1, 0, 1},
		//         {0, 1, 1}
		// };

		boolean pathPossible = ratInMaze(maze);
		System.out.println(pathPossible); // true
	}
}

/*
Time Complexity:
O(4^(n*n))
- Explore all possible paths recursively

Space Complexity:
O(n*n)
- Path matrix and recursive stack

Explanation:
- Move in all four directions
- Avoid blocked and visited cells
- Return true if destination is reached
- Use backtracking for other paths
*/

/*
Sample Input 1:
1 1 0
1 1 0
1 1 1

Sample Output 1:
true


Sample Input 2:
1 1 0
1 0 1
0 1 1

Sample Output 2:
false
*/