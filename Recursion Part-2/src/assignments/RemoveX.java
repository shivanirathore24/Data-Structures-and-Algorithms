package assignments;

/*
Problem Statement:
Given a string, return a new string by removing all occurrences of character 'x' using recursion.
*/

public class RemoveX {
	public static String removeX(String s) {
		// base case
		if (s.length() == 0) {
			return "";
		}
		// recursive call
		String smallOutput = removeX(s.substring(1));
		// calculation
		if (s.charAt(0) == 'x') {
			return smallOutput;   // skip 'x'
		} else {
			return s.charAt(0) + smallOutput;
		}
	}

	public static void main(String[] args) {
		System.out.println(removeX("xaxb"));   // ab
		System.out.println(removeX("abc"));    // abc
	}
}

/*
Time Complexity:
O(n^2)
- substring() takes O(n) time
- called n times

Space Complexity:
O(n)
- recursion stack depth = n

Explanation:
- base case: empty string → return ""
- process first character
- recursively solve for remaining string
- if current char is 'x' → skip it
- else → include it in result
*/

/*
Sample Input 1:
xaxb

Sample Output 1:
ab

Sample Input 2:
abc

Sample Output 2:
abc
*/