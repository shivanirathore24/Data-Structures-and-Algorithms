package assignments;

import java.util.Scanner;

/*
Problem Statement:
Count total number of words in a given string.

Note:
- Words are separated by a single space
- No leading or trailing spaces
*/

public class CountWords {
    public static int countWords(String str) {
        // empty string
        if (str.length() == 0) return 0;

        int count = 0;
        // count spaces
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        // words = spaces + 1
        return count + 1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int count = countWords(str);
        System.out.println(count);
    }
}

/*
Sample Input 1:
Coding Ninjas!

Sample Output 1:
2

Sample Input 2:
this is a sample string

Sample Output 2:
5
*/