package assignments;

/*
Problem Statement:
Remove all consecutive duplicate characters from a string.

Note:
- Keep only one character from each group of duplicates
- Characters are lowercase
*/

public class RemoveConsecutiveDuplicates {
    public static String removeConsecutiveDuplicate(String str) {
        // start with first character
        String outputString = Character.toString(str.charAt(0));

        // traverse string
        for (int i = 1; i < str.length(); i++) {
            // keep if different from previous
            if (str.charAt(i) != str.charAt(i - 1)) {
                outputString += str.charAt(i);
            }
        }
        return outputString;
    }

    public static void main(String[] args) {
        String str = "aabbcccddee";
        System.out.println(removeConsecutiveDuplicate(str)); // abcde
    }
}

/*
Sample Input 1:
aabccbaa

Sample Output 1:
abcba

Sample Input 2:
xxyyzxx

Sample Output 2:
xyzx
*/