package assignments;
import java.util.Stack;

/*
Problem Statement:
Given a string expression, check if it contains redundant brackets.
Redundant brackets are those brackets which do not contain any operator inside them.

Example:
((a+b)) → redundant
(a+b) → not redundant
*/

public class RedundantBracket {
	// O(1)
	private static boolean find(char ch)
	{
		if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
		{
			return true;   // operator found
		}
		return false;
	}

	// O(n)
	public static boolean checkRedundantBrackets(String expression)
	{
		Stack<Character> stk = new Stack<>();
		for (int i = 0; i < expression.length(); i++)
		{
			char ch = expression.charAt(i);
			if (ch == '(' || find(ch))
			{
				stk.push(ch);   // push '(' or operator
			}
			else if (ch == ')')
			{
				boolean hasOperator = false;
				while (!stk.isEmpty() && stk.peek() != '(')
				{
					stk.pop();
					hasOperator = true;   // operator exists inside
				}

				if (!hasOperator)
				{
					return true;   // redundant bracket found
				}

				if (!stk.isEmpty())
				{
					stk.pop();   // remove '('
				}
			}
		}
		return false;   // no redundant brackets
	}

	public static void main(String[] args)
	{
		String str1 = "((a+b))";
		String str2 = "(a+b)";
		String str3 = "(a+(b))";
		System.out.println(checkRedundantBrackets(str1));  // true
		System.out.println(checkRedundantBrackets(str2));  // false
		System.out.println(checkRedundantBrackets(str3));  // true
	}
}

/*
Time Complexity:
O(n)
- Each character is processed once

Space Complexity:
O(n)
- Stack stores characters

Explanation:
- Push '(' and operators into stack
- On ')':
  - Check if any operator exists inside brackets
  - If no operator → redundant
- Pop elements until '('
- If any redundant found → return true
*/

/*
Sample Input 1:
((a+b))

Sample Output 1:
true

Sample Input 2:
(a+b)

Sample Output 2:
false
*/