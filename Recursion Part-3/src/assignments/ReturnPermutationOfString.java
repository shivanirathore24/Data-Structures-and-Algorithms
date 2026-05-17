package assignments;
import java.util.Scanner;

/*
Problem Statement:
Return all permutations of a string using recursion.
*/

public class ReturnPermutationOfString {
    // O(n!)
    public static String[] permutationOfString(String input) {
        // base case
        if (input.length() == 0) {
            String output[] = {""};
            return output;
        }

        String[] smallerOutput = permutationOfString(input.substring(1));
        String[] output = new String[input.length() * smallerOutput.length];

        int k = 0;
        // place current character at every position
        for (int i = 0; i < smallerOutput.length; i++) {
            String currentString = smallerOutput[i];
            for (int j = 0; j <= currentString.length(); j++) {
                output[k] = currentString.substring(0, j) + input.charAt(0)
                        + currentString.substring(j);
                k++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = s.nextLine();

        String output[] = permutationOfString(input);

        System.out.println("Permutations are:");
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
        s.close();
    }
}

/*
Time Complexity:
O(n!)
- All possible permutations are generated

Space Complexity:
O(n!)
- All permutations are stored

Explanation:
- Recursively find smaller permutations
- Insert current character at every position
- Generate all possible arrangements
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