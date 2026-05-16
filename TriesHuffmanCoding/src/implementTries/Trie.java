package implementTries;

/*
Problem Statement:
Implement Trie with add, search, remove and countWords operations.
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

        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];

        // create node if absent
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }

        return addHelper(child, word.substring(1));
    }

    // O(n)
    public boolean search(String word) {
        return searchHelper(root, word);
    }

    // O(n)
    private boolean searchHelper(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminal;
        }

        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];

        if (child == null) {
            return false;
        }

        return searchHelper(child, word.substring(1));
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

        int childIndex = word.charAt(0) - 'A';
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
Add         : O(n)
Search      : O(n)
Remove      : O(n)
CountWords  : O(1)

Space Complexity:
O(n)
- Trie stores characters of inserted words

Explanation:
- Trie stores words character by character
- add() inserts words recursively
- search() checks whether word exists
- remove() deletes unnecessary nodes
- countWords() returns total inserted words
*/