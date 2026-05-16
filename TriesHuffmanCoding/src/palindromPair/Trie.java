package palindromPair;
import java.util.ArrayList;

/*
Problem Statement:
Check whether palindrome pair exists using Trie.
*/

public class Trie {
	private TrieNode root;
	public int count;

	public Trie() {
		root = new TrieNode('\0');
	}

	// O(n)
	private void add(TrieNode root, String word) {
		if (word.length() == 0) {
			root.isTerminal = true;
			return;
		}

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];

		// create node if absent
		if (child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		add(child, word.substring(1));
	}

	// O(n)
	public void add(String word) {
		add(root, word);
	}

	// O(n)
	private boolean search(TrieNode root, String word) {
		if (word.length() == 0) {
			return true;
		}

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];

		if (child == null) {
			return false;
		}

		return search(child, word.substring(1));
	}

	// O(n)
	public boolean search(String word) {
		return search(root, word);
	}

	// O(n)
	private void print(TrieNode root, String word) {
		if (root == null) {
			return;
		}

		if (root.isTerminal) {
			System.out.println(word);
		}

		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}

			String fwd = word + child.data;
			print(child, fwd);
		}
	}

	// O(n)
	public void print() {
		print(this.root, "");
	}

	/* Palindrome Pair */
	// O(n)
	public String reverse(String word) {
		String xString = "";

		for (int i = word.length() - 1; i >= 0; i--) {
			xString += word.charAt(i);
		}
		return xString;
	}

	/*
	 * Time Complexity : O(N * M)
	 * Space Complexity : O(N * M)
	 * where N is number of words
	 * and M is average word length
	 */
	public boolean isPalindromePair(ArrayList<String> words) {
		for (int i = 0; i < words.size(); i++) {
			String string = reverse(words.get(i));
			Trie suffixTrie = new Trie();

			// insert all suffixes
			for (int j = 0; j < string.length(); j++) {
				suffixTrie.add(string.substring(j));
			}

			// search matching word
			for (String word : words) {
				if (suffixTrie.search(word)) {
					return true;
				}
			}
		}
		return false;
	}
}

/*
Time Complexity:
Add               : O(n)
Search            : O(n)
Palindrome Pair   : O(N * M)

Space Complexity:
O(N * M)
- Trie stores suffixes of reversed words

Explanation:
- Reverse every word
- Insert all suffixes into Trie
- Search other words inside Trie
- If match found, palindrome pair exists
*/