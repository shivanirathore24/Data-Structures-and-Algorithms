package autoComplete;
import java.util.ArrayList;

/*
Problem Statement:
Test Auto Complete using Trie.
*/

public class TrieUse {
    public static void main(String[] args) {
        Trie t = new Trie();

        ArrayList<String> input = new ArrayList<String>();
        String[] words = {"do", "dont", "no", "not", "note", "notes", "den"};
        String prefix = "no";

        // add words into list
        for (int i = 0; i < words.length; i++) {
            input.add(words[i]);
        }

        // print auto complete words
        t.autoComplete(input, prefix);
    }
}

/*
Sample Input 1:
do dont no not note notes den
no

Sample Output 1:
no
not
note
notes


Sample Input 2:
do dont no not note notes den
de

Sample Output 2:
den


Sample Input 3:
do dont no not note notes den
nom

Sample Output 3:
(Empty)
*/