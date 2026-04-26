package assignments;

/*
Problem Statement:
Given a string S, remove consecutive duplicate characters using recursion.
*/

public class RemoveDuplicates {
	public static String removeConsecutiveDuplicates(String s) {
		// base case
		if (s == null || s.length() <= 1) {
			return s;
		}

		// check first two characters
		if (s.charAt(0) == s.charAt(1)) {
			// skip current character
			return removeConsecutiveDuplicates(s.substring(1));
		}

		// recursive call
		String smallOutput = removeConsecutiveDuplicates(s.substring(1));
		// include current character
		return s.charAt(0) + smallOutput;
	}

	public static void main(String[] args) {
		System.out.println(removeConsecutiveDuplicates("aaabbbcdeef")); // abcdef
		System.out.println(removeConsecutiveDuplicates("aabccba"));     // abcba
	}
}

/*
Time Complexity:
O(n^2)
- substring() takes O(n)
- called n times

Space Complexity:
O(n)
- recursion stack depth = n

Explanation:
- base case: if string is empty or single char → return it
- compare first and second characters
- if same → skip current character
- else → include current character
- recursively process rest of string
*/

/*
Sample Input 1:
aabccba

Sample Output 1:
abcba

Sample Input 2:
xxxyyyzwwzzz

Sample Output 2:
xyzwz
*/