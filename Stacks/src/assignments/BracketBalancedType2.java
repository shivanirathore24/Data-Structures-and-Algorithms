package assignments;
import java.util.Stack;

/*
Problem Statement:
Given a string expression containing brackets: (), {}, [],
check whether they are balanced or not.

Brackets are balanced if:
- Every opening bracket has a corresponding closing bracket
- Closing follows LIFO order
*/

public class BracketBalancedType2 {
	// O(n)
	public static boolean isBalanced(String expression)
	{
		Stack<Character> stack = new Stack<>();  // use stack for matching
		for(int i = 0; i < expression.length(); i++)
		{
			char currChar = expression.charAt(i);
			if(currChar == '[' || currChar == '{' || currChar == '(')
			{
				stack.push(currChar);   // push opening bracket
			}
			else if(currChar == ']' || currChar == '}' || currChar == ')')
			{
				if(stack.isEmpty())
				{
					return false;   // no matching opening
				}
				else {
					char topChar = stack.pop();   // get last opened
					if(currChar == ')' && topChar == '(' ||
							currChar == '}' && topChar == '{' ||
							currChar == ']' && topChar == '[')
					{
						continue;   // valid match
					}
					else
					{
						return false;   // mismatch
					}
				}
			} // end of else-if
		} // end of loop
		return stack.isEmpty();   // true if all matched
	}

	public static void main(String[] args) {
		String str1 = "[{(a+b)+c*d}+(e+f)]";
		String str2 = "[{a+b)}";
		String str3 = "(a+b)}";
		System.out.println(isBalanced(str1));  // true
		System.out.println(isBalanced(str2));  // false
		System.out.println(isBalanced(str3));  // false
	}
}

/*
Time Complexity:
O(n)
- Each character processed once

Space Complexity:
O(n)
- Stack stores opening brackets

Explanation:
- Traverse string character by character
- Push opening brackets → (, {, [
- On closing bracket:
  - If stack empty → false
  - Pop and check matching pair
- At end:
  - Stack empty → balanced
  - Else → not balanced
*/

/*
Sample Input 1:
[{(a+b)+c*d}+(e+f)]

Sample Output 1:
true

Sample Input 2:
[{a+b)}

Sample Output 2:
false

Sample Input 3:
(a+b)}

Sample Output 3:
false
*/