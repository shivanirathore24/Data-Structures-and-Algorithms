package assignments;

/*
Problem Statement:
Reverse each word in a given sentence.

Note:
- Words are separated by a single space
- No leading or trailing spaces
*/

public class ReverseEachWord {
    public static String reverseEachWord(String str) {
        String ans = "";
        int currentWordStart = 0, i = 0;

        // traverse string
        for (; i < str.length(); i++) {
            // word end found
            if (str.charAt(i) == ' ') {
                // reverse current word
                int currentWordEnd = i - 1;
                String reversedWord = "";
                for (int j = currentWordStart; j <= currentWordEnd; j++) {
                    reversedWord = str.charAt(j) + reversedWord;
                }
                // add to result
                ans += reversedWord + " ";
                currentWordStart = i + 1;
            }
        }
        // reverse last word
        int currentWordEnd = i - 1;
        String reversedWord = "";
        for (int j = currentWordEnd; j >= currentWordStart; j--) {
            reversedWord += str.charAt(j);
        }
        return ans + reversedWord;
    }

    public static void main(String args[]) {
        String str = "abc def ghi jkl";
        System.out.println(reverseEachWord(str)); // cba fed ihg lkj
    }
}

/*
Sample Input 1:
Welcome to Coding Ninjas

Sample Output 1:
emocleW ot gnidoC sajniN

Sample Input 2:
Always indent your code

Sample Output 2:
syawlA tnedni ruoy edoc
*/