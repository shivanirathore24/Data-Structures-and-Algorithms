package questions;
import java.util.Scanner;

/*
Problem Statement:
Return all subsequences of a string using recursion.
*/

public class ReturnSubsequence {
    // O(2^n)
    public static String[] subSequences(String input) {
        // base case
        if (input.length() == 0) {
            String output[] = new String[1];
            output[0] = "";
            return output;
        }

        String[] smallOutput = subSequences(input.substring(1));
        String[] output = new String[smallOutput.length * 2];

        // subsequences without current character
        for (int i = 0; i < smallOutput.length; i++) {
            output[i] = smallOutput[i];
        }

        // subsequences with current character
        for (int i = 0; i < smallOutput.length; i++) {
            output[smallOutput.length + i] =
                    input.charAt(0) + smallOutput[i];
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = sc.next();

        String output[] = subSequences(input);
        System.out.println("Subsequences are:");

        for (String outputString : output) {
            System.out.println(outputString);
        }
        sc.close();
    }
}

/*
Time Complexity:
O(2^n)
- Every character has two choices

Space Complexity:
O(2^n)
- All subsequences are stored

Explanation:
- For every character:
  include it or exclude it
- Combine both recursive results
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