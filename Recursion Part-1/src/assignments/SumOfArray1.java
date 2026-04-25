package assignments;
import java.util.Scanner;

/*
Problem Statement:
Given an array of length N, return the sum of all elements using recursion.
*/

public class SumOfArray1 {
    public static int sum(int input[]) {
        // base case
        if (input.length == 1) {
            return input[0];
        }

        // create smaller array
        int smallArray[] = new int[input.length - 1];
        for (int i = 1; i < input.length; i++) {
            smallArray[i - 1] = input[i];
        }

        // recursive call
        int smallOutput = sum(smallArray);
        // calculation
        return input[0] + smallOutput;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[] = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        System.out.println(sum(input));
    }
}

/*
Time Complexity:
O(n^2)
- At each recursive call, a new array is created (O(n))
- Total calls = n
- Overall = O(n^2)

Space Complexity:
O(n^2)
- Recursive stack = O(n)
- Extra arrays created at each step

Explanation:
- base case: when array has only one element, return it
- break problem → separate first element + remaining array
- recursively compute sum of smaller array
- add first element to recursive result
*/

/*
Sample Input 1:
3
9 8 9

Sample Output 1:
26

Explanation:
9 + 8 + 9 = 26

Sample Input 2:
3
4 2 1

Sample Output 2:
7

Explanation:
4 + 2 + 1 = 7
*/