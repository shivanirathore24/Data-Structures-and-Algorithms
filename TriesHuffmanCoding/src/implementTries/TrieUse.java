package implementTries;

public class TrieUse {
    public static void main(String[] args) {
        Trie t = new Trie();

        // add words
        t.add("SHIV");
        t.add("SHAKTI");
        t.add("SHIVANI");
        t.add("ABHI");

        // search word
        System.out.println(t.search("ABHI")); // true

        // remove word
        t.remove("ABHI");

        // search again
        System.out.println(t.search("ABHI")); // false

        // count total words
        System.out.println(t.countWords()); // 3
    }
}

