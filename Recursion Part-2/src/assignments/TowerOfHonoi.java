package assignments;

/*
Problem Statement:
Given n disks and three rods (source, helper, destination), print steps to solve Tower of Hanoi using recursion.
*/

public class TowerOfHonoi {
    public static void towerOfHanoi(int n, char s, char h, char d) {
        // handle invalid case
        if (n <= 0) {
            return;
        }

        // base case
        if (n == 1) {
            System.out.println("move 1st disk from " + s + " to " + d);
            return;
        }

        // move n-1 disks from source → helper
        towerOfHanoi(n - 1, s, d, h);

        // move nth disk
        System.out.println("move " + getSuffix(n) + " disk from " + s + " to " + d);

        // move n-1 disks from helper → destination
        towerOfHanoi(n - 1, h, s, d);
    }

    // helper function for correct suffix
    public static String getSuffix(int n) {
        if (n % 10 == 1 && n % 100 != 11) return n + "st";
        if (n % 10 == 2 && n % 100 != 12) return n + "nd";
        if (n % 10 == 3 && n % 100 != 13) return n + "rd";
        return n + "th";
    }

    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n, 'A', 'B', 'C');
    }
}

/*
Time Complexity:
O(2^n)
- Total moves = 2^n - 1

Space Complexity:
O(n)
- Recursion stack depth

Explanation:
- move n-1 disks to helper
- move largest disk
- move n-1 disks to destination
*/

/*
Sample Input 1:
2

Sample Output 1:
move 1st disk from A to B
move 2nd disk from A to C
move 1st disk from B to C

Sample Input 2:
3

Sample Output 2:
move 1st disk from A to C
move 2nd disk from A to B
move 1st disk from C to B
move 3rd disk from A to C
move 1st disk from B to A
move 2nd disk from B to C
move 1st disk from A to C
*/