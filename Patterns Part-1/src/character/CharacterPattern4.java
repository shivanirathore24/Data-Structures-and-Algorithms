package character;
import java.util.Scanner;

public class CharacterPattern4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int i = 1;
        while (i <= n) {
            char p = (char) ('A' + i - 1);
            int j = 1;
            while (j <= i) {
                System.out.print(p);
                p = (char) (p + 1);
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
BC
CDE

Sample Input 2:
5
Sample Output 2:
A
BC
CDE
DEFG
EFGHI
*/