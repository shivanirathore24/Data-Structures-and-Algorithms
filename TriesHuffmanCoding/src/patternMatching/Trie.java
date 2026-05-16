package patternMatching;
import java.util.ArrayList;

/*
Problem Statement:
Check whether a pattern exists in given list of words using Trie.
*/

public class Trie {
    private TrieNode root;
    private int numWords;

    public Trie() {
        root = new TrieNode('\0');
        numWords = 0;
    }

    // O(n)
    public void add(String word) {
        if (addHelper(root, word)) {
            numWords++;
        }
    }

    // O(n)
    private boolean addHelper(TrieNode root, String word) {
        if (word.length() == 0) {
            if (root.isTerminal) {
                return false;
            } else {
                root.isTerminal = true;
                return true;
            }
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        // create node if absent
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }

        return addHelper(child, word.substring(1));
    }

    /*
     * Time Complexity : O(N * M)
     * Space Complexity : O(N * M)
     * where N is number of words
     * and M is average word length
     */

    public boolean patternMatching(ArrayList<String> input, String pattern) {
        for (int i = 0; i < input.size(); i++) {
            String string = input.get(i);
            Trie suffixTrie = new Trie();

            // insert all suffixes
            for (int j = 0; j < string.length(); j++) {
                suffixTrie.add(string.substring(j));
            }

            // search pattern
            if (suffixTrie.search(pattern)) {
                return true;
            }
        }
        return false;
    }

    // O(n)
    public boolean search(String word) {
        return search(root, word);
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
    public void remove(String word) {
        if (removeHelper(root, word)) {
            numWords--;
        }
    }

    // O(n)
    private boolean removeHelper(TrieNode root, String word) {
        if (word.length() == 0) {
            if (root.isTerminal) {
                root.isTerminal = false;
                return true;
            } else {
                return false;
            }
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if (child == null) {
            return false;
        }

        boolean ans = removeHelper(child, word.substring(1));

        // remove useless node
        if (!child.isTerminal && child.childCount == 0) {
            root.children[childIndex] = null;
            root.childCount--;
        }
        return ans;
    }

    // O(1)
    public int countWords() {
        return numWords;
    }
}

/*
Time Complexity:
Add              : O(n)
Search           : O(n)
Remove           : O(n)
PatternMatching  : O(N * M)

Space Complexity:
O(N * M)
- Trie stores all suffixes of words

Explanation:
- Insert all suffixes of every word into Trie
- Search the pattern in suffix Trie
- If pattern exists, return true
- Otherwise return false
*/

