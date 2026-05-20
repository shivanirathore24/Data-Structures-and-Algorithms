package commonSubsequence;

/*
Problem Statement:
Find length of Longest Common Subsequence between two strings.
*/

public class LCSRecursive {
    public static int lcsR1(String str1, String str2, int i, int j) {
        // base case
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }

        int myAns;

        // characters match
        if (str1.charAt(i) == str2.charAt(j)) {
            int smallAns = lcsR1(str1, str2, i + 1, j + 1);
            myAns = 1 + smallAns;
        } else {
            // skip character from first string
            int ans1 = lcsR1(str1, str2, i + 1, j);

            // skip character from second string
            int ans2 = lcsR1(str1, str2, i, j + 1);

            myAns = Math.max(ans1, ans2);
        }
        return myAns;
    }

    public static void main(String[] args) {
        String str1 = "adebc";
        String str2 = "dcadb";

        int ans = lcsR1(str1, str2, 0, 0);
        System.out.println(ans); // 3
    }
}

/*
Time Complexity:
O(2^(m+n))
- Two recursive calls are made at each step

Space Complexity:
O(m+n)
- Recursive stack space
*/

/*
Explanation:
- If characters match, include them
- Otherwise try both possibilities
- Take maximum subsequence length
*/

/*
Sample Input 1:
adebc
dcadb

Sample Output 1:
3


Sample Input 2:
ab
defg

Sample Output 2:
0
*/