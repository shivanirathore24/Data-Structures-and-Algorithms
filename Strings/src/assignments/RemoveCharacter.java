package assignments;

/*
Problem Statement:
Remove all occurrences of a given character X from the string.

Note:
If X is not present, return the original string.
*/

public class RemoveCharacter {
	public static String removeAllOccurrencesOfChar(String str, char ch) {
		String ans = "";
		// traverse string
		for (int i = 0; i < str.length(); i++) {
			// keep only non-matching characters
			if (str.charAt(i) != ch) {
				ans += str.charAt(i);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String str = "abacd";
		char ch = 'a';
		System.out.println(removeAllOccurrencesOfChar(str, ch)); // bcd
	}
}

/*
Sample Input 1:
aabccbaa
a

Sample Output 1:
bccb

Sample Input 2:
xxyyzxx
y

Sample Output 2:
xxzxx
*/