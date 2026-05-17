package ratInMaze;

/*
Problem Statement:
Print all possible paths in Rat In A Maze problem.
*/

public class RatInMaze2 {
    // O(4^(n*n))
    public static void ratInMaze(int[][] maze) {
        int n = maze.length;
        int path[][] = new int[n][n];
        printAllPaths(maze, 0, 0, path);
    }

    // O(4^(n*n))
    public static void printAllPaths(int[][] maze, int i, int j, int[][] path) {
        int n = maze.length;

        // invalid cell
        if (i < 0 || i >= n ||
                j < 0 || j >= n ||
                maze[i][j] == 0 ||
                path[i][j] == 1) {
            return;
        }

        // include current cell
        path[i][j] = 1;

        // destination reached
        if (i == n - 1 && j == n - 1) {
            // print path
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    System.out.print(path[r][c] + " ");
                }
                System.out.println();
            }
            System.out.println();
            path[i][j] = 0;
            return;
        }

        // explore all directions
        printAllPaths(maze, i - 1, j, path); // top
        printAllPaths(maze, i, j + 1, path); // right
        printAllPaths(maze, i + 1, j, path); // down
        printAllPaths(maze, i, j - 1, path); // left

        // backtrack
        path[i][j] = 0;
    }

    public static void main(String[] args) {
        int maze[][] = {
                {1, 1, 0},
                {1, 1, 0},
                {1, 1, 1}
        };
        ratInMaze(maze);
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
- Mark visited cells in path matrix
- Print path when destination is reached
- Backtrack to explore other paths
*/

/*
Sample Input 1:
1 1 0
1 1 0
1 1 1

Sample Output 1:
1 1 0
0 1 0
0 1 1

1 1 0
1 1 0
1 1 1

1 0 0
1 1 0
0 1 1

1 0 0
1 0 0
1 1 1


Sample Input 2:
1 1 0
1 0 1
0 1 1

Sample Output 2:
No Path Exists


Sample Input 3:
1 0 0
1 1 0
0 1 1

Sample Output 3:
1 0 0
1 1 0
0 1 1
*/