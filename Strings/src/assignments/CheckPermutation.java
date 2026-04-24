package assignments;
import java.util.Scanner;

/*
Problem Statement:
Check whether two given strings are permutations of each other.

Definition:
Two strings are permutations if they have same characters with same frequency,
only their order is different.
*/

public class CheckPermutation {
    public static boolean checkPermutation(String str1, String str2) {
        // length check
        if (str1.length() != str2.length()) {
            return false;
        }

        // frequency array (ASCII)
        int[] frequency = new int[256];

        // count characters of str1
        for (int i = 0; i < str1.length(); i++) {
            frequency[str1.charAt(i)]++;
        }

        // reduce using str2
        for (int i = 0; i < str2.length(); i++) {
            frequency[str2.charAt(i)]--;
        }

        // check all values are zero
        for (int i = 0; i < 256; i++) {
            if (frequency[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine();
        String str2 = s.nextLine();
        System.out.println(checkPermutation(str1, str2));
    }
}

/*
Sample Input 1:
abcde
baedc

Sample Output 1:
true

Sample Input 2:
abc
cbd

Sample Output 2:
false
*/