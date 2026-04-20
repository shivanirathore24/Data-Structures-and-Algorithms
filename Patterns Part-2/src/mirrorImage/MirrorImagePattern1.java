package mirrorImage;
import java.util.Scanner;

public class MirrorImagePattern1 {
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

            int stars = 1;
            while (stars <= i) {
                System.out.print('*');
                stars++;
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
  *
 **
***

Sample Input 2:
5
Sample Output 2:
    *
   **
  ***
 ****
*****
*/