package assignments;
import java.util.HashMap;

/*
Problem Statement:
Given a string S, remove all duplicate characters.
The output string should contain each character only once
while maintaining the original order.
*/

public class ExtractUniqueCharacters {
    // O(n)
    public static String uniqueChar(String str) {
        if (str.length() == 0) {
            return "";
        }

        String ans = "";
        HashMap<Character, Boolean> hm = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);

            // add character only once
            if (!hm.containsKey(currChar)) {
                hm.put(currChar, true);
                ans += currChar;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "ababacd";
        System.out.println(uniqueChar(str)); // abcd
    }
}

/*
Time Complexity:
O(n)
- Each character is visited once

Space Complexity:
O(n)
- HashMap stores unique characters

Explanation:
- Traverse the string character by character
- Add only first occurrence of each character
- Maintain original order of characters
*/

/*
Sample Input 1:
ababacd

Sample Output 1:
abcd

Sample Input 2:
abcde

Sample Output 2:
abcde
*/