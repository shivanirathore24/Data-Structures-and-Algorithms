package mirrorImage;
import java.util.Scanner;

public class MirrorImagePattern2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int i = 1;
        while (i <= n) {
            int spaces = 1;
            while (spaces <= n - i) {
                System.out.print(' ');
                spaces++;
            }

            int num = 1;
            while (num <= i) {
                System.out.print(num);
                num++;
            }
            System.out.println();
            i++;
        }
    }
}

/*
Sample Input 1:
3
Sample Output 1:
  1
 12
123

Sample Input 2:
5
Sample Output 2:
    1
   12
  123
 1234
12345
*/