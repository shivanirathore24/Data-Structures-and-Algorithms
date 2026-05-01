package assignments;
import java.util.Stack;

/*
Problem Statement:
For a given string expression containing only round brackets '()',
check if they are balanced or not.

Brackets are balanced if the last opened bracket is closed first (LIFO).
*/

public class BracketBalancedType1 {
	// O(n)
	public static boolean isBalanced(String expression)
	{
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < expression.length(); i++)
		{
			char ch = expression.charAt(i);
			if(ch == '(')
			{
				stack.push(ch);   // push opening bracket
			}
			else if (ch == ')')
			{
				if(stack.isEmpty()) {
					return false;   // no matching opening
				}

				char topChar = stack.pop();   // remove last opened

				if(ch == ')' && topChar == '(')
				{
					continue;   // valid pair
				}
				else {
					return false;   // mismatch
				}
			}
		}
		return stack.isEmpty();   // true if all matched
	}

	public static void main(String[] args) {
		String str1 = "(()()())";
		String str2 = "()()(()";
		System.out.println(isBalanced(str1));  // true
		System.out.println(isBalanced(str2));  // false
	}
}

/*
Time Complexity:
O(n)
- Each character is processed once

Space Complexity:
O(n)
- Stack stores opening brackets in worst case

Explanation:
- Traverse string character by character
- Push '(' into stack
- On ')':
  - If stack empty → false
  - Else pop and check match
- After traversal:
  - If stack empty → balanced
  - Else → not balanced
*/

/*
Sample Input 1:
(()()())

Sample Output 1:
true

Sample Input 2:
()()(()

Sample Output 2:
false
*/