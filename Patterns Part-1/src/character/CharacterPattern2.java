package character;
import java.util.Scanner;

public class CharacterPattern2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                char ithchar = (char) ('A' + i - 1);
                System.out.print(ithchar);
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
A
BB
CCC

Sample Input 2:
5
Sample Output 2:
A
BB
CCC
DDDD
EEEEE
*/