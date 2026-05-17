package questions;
import java.util.Scanner;

/*
Problem Statement:
Return all possible keypad combinations using recursion.
*/

public class ReturnKeypadCombination {
    // O(1)
    public static String getOptions(int digit) {
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
    public static String[] keypadCombinations(int input) {
        // base case
        if (input == 0) {
            String[] output = new String[1];
            output[0] = "";
            return output;
        }

        String[] smallOutput = keypadCombinations(input / 10);
        int lastDigit = input % 10;
        String lastDigitOptions = getOptions(lastDigit);
        String[] output = new String[smallOutput.length * lastDigitOptions.length()];

        int k = 0;
        // generate combinations
        for (int i = 0; i < smallOutput.length; i++) {
            for (int j = 0; j < lastDigitOptions.length(); j++) {
                output[k] = smallOutput[i] + lastDigitOptions.charAt(j);
                k++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number:");
        int input = sc.nextInt();

        String[] output = keypadCombinations(input);
        System.out.println("Keypad combinations are:");

        for (String outputString : output) {
            System.out.println(outputString);
        }
        sc.close();
    }
}

/*
Time Complexity:
O(4^n)
- Every digit can generate at most 4 choices

Space Complexity:
O(4^n)
- All combinations are stored

Explanation:
- Find keypad characters for each digit
- Combine previous answers recursively
- Generate all possible combinations
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