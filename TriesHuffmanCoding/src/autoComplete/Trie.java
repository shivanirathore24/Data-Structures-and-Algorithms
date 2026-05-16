package autoComplete;
import java.util.ArrayList;

/*
Problem Statement:
Implement Auto Complete using Trie.
*/

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    // O(n)
    public void add(String word) {
        addHelper(root, word);
    }

    // O(n)
    private void addHelper(TrieNode root, String word) {
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

        addHelper(child, word.substring(1));
    }

    // O(n)
    private void printAllWords(TrieNode root, String word) {
        if (root == null) {
            return;
        }

        // complete word found
        if (root.isTerminal) {
            System.out.println(word);
        }

        for (int i = 0; i < 26; i++) {
            TrieNode child = root.children[i];
            if (child != null) {
                printAllWords(child, word + child.data);
            }
        }
    }

    /*
     * Time Complexity : O(N * M)
     * Space Complexity : O(N * M)
     * where N is number of words
     * and M is average word length
     */

    public void autoComplete(ArrayList<String> input, String word) {
        // insert all words
        for (int i = 0; i < input.size(); i++) {
            add(input.get(i));
        }

        TrieNode current = root;

        // move till prefix
        for (int i = 0; i < word.length(); i++) {
            int childIndex = word.charAt(i) - 'a';
            TrieNode child = current.children[childIndex];

            // prefix not found
            if (child == null) {
                return;
            }
            current = child;
        }

        // print all matching words
        printAllWords(current, word);
    }
}

/*
Time Complexity:
Add           : O(n)
AutoComplete  : O(N * M)

Space Complexity:
O(N * M)
- Trie stores all words

Explanation:
- Insert all words into Trie
- Traverse Trie till given prefix
- Print all words starting with prefix
*/
