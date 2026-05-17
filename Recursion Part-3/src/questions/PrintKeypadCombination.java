package questions;

import java.util.Scanner;

/*
Problem Statement:
Print all keypad combinations using recursion.
*/

public class PrintKeypadCombination {
    // O(1)
    public static String getOptions(int digit) {
        if (digit < 1 || digit > 10) {
            System.exit(0);
        }

        if (digit == 2) {
            return "abc";
        }

        if (digit == 3) {
            return "def";
        }

        if (digit == 4) {
            return "ghi";
        }

        if (digit == 5) {
            return "jkl";
        }

        if (digit == 6) {
            return "mno";
        }

        if (digit == 7) {
            return "pqrs";
        }

        if (digit == 8) {
            return "tuv";
        }

        if (digit == 9) {
            return "wxyz";
        }
        return "";
    }

    // O(4^n)
    public static void printKeypadCombinations(int input, String stringSoFar) {
        // base case
        if (input == 0) {
            System.out.println(stringSoFar);
            return;
        }

        int lastDigit = input % 10;
        int smallInput = input / 10;
        String optionsLastDigit = getOptions(lastDigit);

        // generate combinations
        for (int i = 0; i < optionsLastDigit.length(); i++) {
            printKeypadCombinations(smallInput, optionsLastDigit.charAt(i) + stringSoFar);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Keypad Number:");
        int input = sc.nextInt();

        System.out.println("Keypad combinations are:");
        printKeypadCombinations(input, "");
        sc.close();
    }
}

/*
Time Complexity:
O(4^n)
- Every digit can generate at most 4 choices

Space Complexity:
O(n)
- Recursive stack stores function calls

Explanation:
- Get keypad characters for each digit
- Recursively generate combinations
- Combine current character with answer
*/

/*
Sample Input 1:
23

Sample Output 1:
ad
ae
af
bd
be
bf
cd
ce
cf


Sample Input 2:
79

Sample Output 2:
pw
px
py
pz
qw
qx
qy
qz
rw
rx
ry
rz
sw
sx
sy
sz
*/