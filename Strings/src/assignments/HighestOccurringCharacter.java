package assignments;

/*
Problem Statement:
Find the highest occurring character in a string.

Note:
- If multiple characters have same frequency, return the one
  which appears first in the string.
- All characters are lowercase.
*/

public class HighestOccurringCharacter {
	public static char highestOccuringChar(String str) {
		// frequency array
		int[] frequency = new int[256];

		// count characters
		for (int i = 0; i < str.length(); i++) {
			frequency[str.charAt(i)]++;
		}

		// find max frequency character
		int maxCount = 0;
		char maxchar = str.charAt(0);

		for (int i = 0; i < str.length(); i++) {
			char currchar = str.charAt(i);
			if (frequency[currchar] > maxCount) {
				maxCount = frequency[currchar];
				maxchar = currchar;
			}
		}
		return maxchar;
	}

	public static void main(String[] args) {
		String str = "abdefgbabfaa";
		System.out.println(highestOccuringChar(str)); // a
	}
}

/*
Sample Input 1:
abdefgbabfba

Sample Output 1:
b

Sample Input 2:
xy

Sample Output 2:
x
*/