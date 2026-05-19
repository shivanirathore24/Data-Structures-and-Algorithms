package assignments;

/*
Problem Statement:
Shiv and Shakti are playing a coin tower game.
In one move, player can remove 1, X or Y coins.
Player making the last move wins.
Find who will win if Shiv starts first.
*/

public class CoinTower {
    // O(3^n)
    public static String findWinnerR1(int n, int x, int y) {
        // losing state
        if(n == 0) {
            return "Shakti";
        }

        boolean move1 = false;
        boolean moveX = false;
        boolean moveY = false;

        if(n - 1 >= 0) {
            move1 = findWinnerR1(n - 1, x, y).equals("Shakti");
        }

        if(n - x >= 0) {
            moveX = findWinnerR1(n - x, x, y).equals("Shakti");
        }

        if(n - y >= 0) {
            moveY = findWinnerR1(n - y, x, y).equals("Shakti");
        }

        // winning state
        if(move1 || moveX || moveY) {
            return "Shiv";
        }

        return "Shakti";
    }

    // O(n)
    public static String findWinnerR2(int n, int x, int y, String[] dp) {
        // losing state
        if(n == 0) {
            return "Shakti";
        }

        // already calculated
        if(dp[n] != null) {
            return dp[n];
        }

        boolean move1 = false;
        boolean moveX = false;
        boolean moveY = false;

        if(n - 1 >= 0) {
            move1 = findWinnerR2(n - 1, x, y, dp).equals("Shakti");
        }

        if(n - x >= 0) {
            moveX = findWinnerR2(n - x, x, y, dp).equals("Shakti");
        }

        if(n - y >= 0) {
            moveY = findWinnerR2(n - y, x, y, dp).equals("Shakti");
        }

        // current player can force win
        if(move1 || moveX || moveY) {
            dp[n] = "Shiv";
        }
        else {
            dp[n] = "Shakti";
        }

        return dp[n];
    }

    // O(n)
    public static String findWinnerI(int n, int x, int y) {
        String[] dp = new String[n + 1];
        dp[0] = "Shakti";

        for(int i = 1; i <= n; i++) {
            if((i - 1) >= 0 && dp[i - 1].equals("Shakti")) {
                dp[i] = "Shiv";
            }
            else if((i - x) >= 0 && dp[i - x].equals("Shakti")) {
                dp[i] = "Shiv";
            }
            else if((i - y) >= 0 && dp[i - y].equals("Shakti")) {
                dp[i] = "Shiv";
            }
            else {
                dp[i] = "Shakti";
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int x = 2;
        int y = 4;

        String[] dp = new String[n + 1];

        System.out.println("Brute Force Recursive Answer:");
        System.out.println(findWinnerR1(n, x, y)); // Shiv

        System.out.println("Recursive Optimized Answer:");
        System.out.println(findWinnerR2(n, x, y, dp)); // Shiv

        System.out.println("Iterative Optimized Answer:");
        System.out.println(findWinnerI(n, x, y)); // Shiv
    }
}

/*
Time Complexity:
Brute Force Recursive : O(3^n)
Recursive Optimized   : O(n)
Iterative Optimized   : O(n)

Space Complexity:
Brute Force Recursive : O(n)
Recursive Optimized   : O(n)
Iterative Optimized   : O(n)

Explanation:
- If any next move makes opponent lose,
  then current player wins
- Shiv starts first
- Recursive optimized stores previous answers
- Iterative approach builds answer bottom-up
*/

/*
Sample Input 1:
4 2 3

Sample Output 1:
Brute Force Recursive Answer:
Shakti
Recursive Optimized Answer:
Shakti
Iterative Optimized Answer:
Shakti


Sample Input 2:
10 2 4

Sample Output 2:
Brute Force Recursive Answer:
Shiv
Recursive Optimized Answer:
Shiv
Iterative Optimized Answer:
Shiv
*/