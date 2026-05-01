package assignments;
import java.util.Stack;

/*
Problem Statement:
For a given expression containing only '{' and '}',
find the minimum number of reversals required to make it balanced.

If not possible, return -1.
*/

public class MinimumBracketReversal {
	// O(n)
	public static int countBracketReversals(String input) {
		int len = input.length();

		// Only even length strings can be balanced
		if (len % 2 != 0) {
			return -1;
		}

		Stack<Character> stack = new Stack<>();

		// Step 1: Remove balanced brackets
		for (int i = 0; i < len; i++) {
			char c = input.charAt(i);

			if (c == '{') {
				stack.push(c);   // push opening
			} else {
				// if matching pair exists → remove
				if (!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else {
					stack.push(c);   // push unbalanced closing
				}
			}
		}

		int count = 0;

		// Step 2: Process remaining unbalanced brackets
		while (!stack.isEmpty()) {
			char c1 = stack.pop();
			char c2 = stack.pop();

			// Case 1: different → "}{" → 2 reversals
			if (c1 != c2) {
				count += 2;
			}
			// Case 2: same → "{{" or "}}" → 1 reversal
			else {
				count += 1;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		String str1 = "}{";
		String str2 = "{{";
		String str3 = "{{{}}{{";
		String str4 = "}}}{{{";
		System.out.println(countBracketReversals(str1)); // 2
		System.out.println(countBracketReversals(str2)); // 1
		System.out.println(countBracketReversals(str3)); // -1
		System.out.println(countBracketReversals(str4)); // 4
	}
}

/*
Time Complexity:
O(n)
- Each character processed once

Space Complexity:
O(n)
- Stack stores unbalanced brackets

Explanation:
- Remove all balanced pairs using stack
- Only unbalanced brackets remain
- Process in pairs:
  - Different → 2 reversals
  - Same → 1 reversal
*/

/*
Sample Input 1:
}{

Sample Output 1:
2

Sample Input 2:
{{{{

Sample Output 2:
2

Sample Input 3:
}{{}}{{{

Sample Output 3:
3
*/