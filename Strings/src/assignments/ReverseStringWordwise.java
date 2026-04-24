package assignments;

/*
Problem Statement:
Reverse the string word-wise.

Note:
- Order of words is reversed
- Characters inside each word remain same
*/

public class ReverseStringWordwise {
	public static String reverseWordwise(String input) {
		// reverse full string
		String reverseString = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			reverseString += input.charAt(i);
		}

		String ans = "";
		int currentWordStart = 0, i = 0;

		// traverse reversed string
		for (; i < reverseString.length(); i++) {
			// word end found
			if (reverseString.charAt(i) == ' ') {
				// reverse current word
				int currentWordEnd = i - 1;
				String reverseWord = "";
				for (int j = currentWordEnd; j >= currentWordStart; j--) {
					reverseWord += reverseString.charAt(j);
				}
				// add to result
				ans += reverseWord + " ";
				currentWordStart = i + 1;
			}
		}
		// reverse last word
		int currentWordEnd = i - 1;
		String reverseWord = "";
		for (int j = currentWordEnd; j >= currentWordStart; j--) {
			reverseWord += reverseString.charAt(j);
		}
		return ans + reverseWord;
	}

	public static void main(String args[]) {
		String str = "abc def ghi jkl";
		System.out.println(reverseWordwise(str)); // jkl ghi def abc
	}
}

/*
Sample Input 1:
Welcome to Coding Ninjas

Sample Output 1:
Ninjas Coding to Welcome

Sample Input 2:
Always indent your code

Sample Output 2:
code your indent Always
*/