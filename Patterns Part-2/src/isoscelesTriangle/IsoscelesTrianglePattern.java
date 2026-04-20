package isoscelesTriangle;
import java.util.Scanner;

public class IsoscelesTrianglePattern {
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

            int dec = i - 1;
            while (dec >= 1) {
                System.out.print(dec);
                dec--;
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
 121
12321

Sample Input 2:
5
Sample Output 2:
    1
   121
  12321
 1234321
123454321
*/