package assignments;
import java.util.Scanner;

/*
Problem Statement:
Print a diamond star pattern for a given odd number N.
*/

public class DiamondStarsPattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        int i = 1;
        int n1 = (N + 1) / 2;
        while (i <= n1) {
            int spaces = 1;
            while (spaces <= n1 - i) {
                System.out.print(" ");
                spaces++;
            }

            int j = 1;
            while (j <= (2 * i - 1)) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }

        int n2 = N / 2;
        i = n2;
        while (i >= 1) {
            int spaces = 1;
            while (spaces <= (n2 - i + 1)) {
                System.out.print(" ");
                spaces++;
            }

            int j = 2 * i - 1;
            while (j >= 1) {
                System.out.print("*");
                j--;
            }
            System.out.println();
            i--;
        }
    }
}

/*
Sample Input 1:
3

Sample Output 1:
  *
 ***
  *

Sample Input 2:
5

Sample Output 2:
  *
 ***
*****
 ***
  *
*/