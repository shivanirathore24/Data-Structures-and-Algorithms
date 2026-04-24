package assignments;

/*
Problem Statement:
Compress the string by replacing consecutive repeated characters
with character + count (only if count > 1).

Note:
Count of any character is ≤ 9.
*/

public class CompressString {
    public static String getCompressedString(String input) {
        // start with first character
        String output = "" + input.charAt(0);
        int count = 1;

        // traverse string
        for (int i = 1; i < input.length(); i++) {
            // check same character
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                // append count if >1
                if (count > 1) {
                    output = output + count;
                }
                // append new character
                output = output + input.charAt(i);
                count = 1;
            }
        }
        // handle last group
        if (count > 1) {
            output = output + count;
        }
        return output;
    }

    public static void main(String[] args) {
        String str = "xxxyyzz";
        String str1 = "xxxxx";
        System.out.println(getCompressedString(str));  // x3y2z2
        System.out.println(getCompressedString(str1)); // x5
    }
}

/*
Sample Input 1:
aaabbccdsa

Sample Output 1:
a3b2c2dsa

Sample Input 2:
aaabbcddeeeee

Sample Output 2:
a3b2cd2e5
*/