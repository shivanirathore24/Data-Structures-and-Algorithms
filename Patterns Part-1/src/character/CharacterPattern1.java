package character;
import java.util.Scanner;

public class CharacterPattern1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                char jthchar = (char) ('A' + j - 1);
                System.out.print(jthchar);
                j = j + 1;
            }
            System.out.println();
            i = i + 1;
        }
    }
}

/*
Sample Input 1:
3
Sample Output 1:
ABC
ABC
ABC

Sample Input 2:
5
Sample Output 2:
ABCDE
ABCDE
ABCDE
ABCDE
ABCDE
*/