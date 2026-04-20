package starPyramid;
import java.util.Scanner;

public class StarPyramidPattern2 {
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

            int j = 1;
            while (j <= 2 * i - 1) {
                System.out.print('*');
                j++;
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
 ***
*****

Sample Input 2:
5
Sample Output 2:
    *
   ***
  *****
 *******
*********
*/