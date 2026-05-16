package patternMatching;
import java.util.ArrayList;

public class TrieUse {
    public static void main(String[] args) {
        Trie t = new Trie();

        ArrayList<String> input = new ArrayList<String>();
        String[] words = {"abc", "def", "ghi", "cba"};
        String pattern = "hif";

        // add words into list
        for (int i = 0; i < words.length; i++) {
            input.add(words[i]);
        }

        // check pattern
        boolean result = t.patternMatching(input, pattern);
        System.out.println(result); // false
    }
}

/*
Sample Input 1:
abc def ghi cba
de

Sample Output 1:
true


Sample Input 2:
abc def ghi hg
hi

Sample Output 2:
true


Sample Input 3:
abc def ghi hg
hif

Sample Output 3:
false
*/