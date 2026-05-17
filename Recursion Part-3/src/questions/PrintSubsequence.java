package questions;
import java.util.Scanner;

/*
Problem Statement:
Print all subsequences of a string using recursion.
*/

public class PrintSubsequence {
    // O(2^n)
    public static void printSubsequences(String input, String stringSoFar) {
        // base case
        if (input.length() == 0) {
            System.out.println(stringSoFar);
            return;
        }

        String smallInput = input.substring(1);

        // exclude current character
        printSubsequences(smallInput, stringSoFar);

        // include current character
        printSubsequences(smallInput, stringSoFar + input.charAt(0));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = sc.next();

        System.out.println("Subsequences are:");
        printSubsequences(input, "");
        sc.close();
    }
}

/*
Time Complexity:
O(2^n)
- Every character has two choices

Space Complexity:
O(n)
- Recursive stack stores function calls

Explanation:
- For every character:
  include it or exclude it
- Recursively generate all subsequences
- Total subsequences become 2^n
*/

/*
Sample Input 1:
abc

Sample Output 1:

c
b
bc
a
ac
ab
abc


Sample Input 2:
xy

Sample Output 2:

y
x
xy
*/