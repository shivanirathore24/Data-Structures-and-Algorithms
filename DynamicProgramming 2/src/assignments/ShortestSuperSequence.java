package assignments;

/*
Problem Statement:
Given two strings, find the length of their
Shortest Super Sequence.

Shortest Super Sequence is the smallest string
that contains both strings as subsequences.
*/

public class ShortestSuperSequence {
    public static int smallestSuperSequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] superseq = new int[len1 + 1][len2 + 1];

        for(int p = 0; p <= len1; p++) {
            for(int q = 0; q <= len2; q++) {
                // first string empty
                if(p == 0) {
                    superseq[p][q] = q;
                }
                // second string empty
                else if(q == 0) {
                    superseq[p][q] = p;
                }
                // characters matched
                else if(str1.charAt(p - 1) == str2.charAt(q - 1)) {
                    superseq[p][q] = 1 + superseq[p - 1][q - 1];
                }
                // characters not matched
                else {
                    superseq[p][q] = 1 + Math.min(superseq[p - 1][q], superseq[p][q - 1]);
                }
            }
        }
        return superseq[len1][len2];
    }

    public static void main(String[] args) {
        String str1 = "algorithm";
        String str2 = "rhythm";

        int ans = smallestSuperSequence(str1, str2);
        System.out.println(ans); // 11
    }
}

/*
Time Complexity:
O(m*n)
- Every cell is calculated once

Space Complexity:
O(m*n)
- DP array is used
*/

/*
Explanation:
- If characters match,
  move diagonally and add 1
- If characters do not match,
  take minimum from top or left and add 1
- First row and first column handle empty strings
*/

/*
Sample Input 1:
ab
ac

Sample Output 1:
3


Sample Input 2:
pqqrpt
qerepct

Sample Output 2:
9


Sample Input 3:
algorithm
rhythm

Sample Output 3:
11
*/