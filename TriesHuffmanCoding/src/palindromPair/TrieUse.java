package palindromPair;
import java.util.ArrayList;

/*
Problem Statement:
Test Palindrome Pair using Trie.
*/

public class TrieUse {
	public static void main(String[] args) {
		Trie t = new Trie();

		ArrayList<String> input = new ArrayList<String>();
		String[] words = {"abc", "def", "ghi", "cba"};

		// String[] words = {"abc", "def"};

		// add words into list
		for (int i = 0; i < words.length; i++) {
			input.add(words[i]);
		}

		// check palindrome pair
		boolean result = t.isPalindromePair(input);
		System.out.println(result); // true
	}
}

/*
Sample Input 1:
abc def ghi cba

Sample Output 1:
true


Sample Input 2:
abc def

Sample Output 2:
false
*/