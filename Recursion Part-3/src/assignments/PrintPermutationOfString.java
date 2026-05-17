package assignments;
import java.util.Scanner;

/*
Problem Statement:
Print all permutations of a string using recursion.
*/

public class PrintPermutationOfString {
    /*
     * Time Complexity : O(n * n!)
     * There are n! permutations and each takes O(n)
     */
    public static void permutationsOfString(String input) {
        permutationOfStringHelper(input, "");
    }

    public static void permutationOfStringHelper(String input, String output) {
        // base case
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        // fix every character one by one
        for (int i = 0; i < input.length(); i++) {
            String smallInput = input.substring(0, i) + input.substring(i + 1);
            permutationOfStringHelper(smallInput, output + input.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = s.nextLine();

        System.out.println("Permutations are:");
        permutationsOfString(input);
        s.close();
    }
}

/*
Time Complexity:
O(n * n!)
- All permutations are generated

Space Complexity:
O(n)
- Recursive stack stores function calls

Explanation:
- Pick one character at a time
- Recursively permute remaining string
- Append chosen character to output
*/

/*
Sample Input 1:
abc

Sample Output 1:
abc
acb
bac
bca
cab
cba


Sample Input 2:
ab

Sample Output 2:
ab
ba
*/