package assignments;
import java.util.Scanner;

/*
Problem Statement:
Write a program to print parallelogram pattern for the given N number of rows.
*/

public class ParallelogramPattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int i = 1;
        while (i <= n) {
            int spaces = 1;
            while (spaces <= (i - 1)) {
                System.out.print(" ");
                spaces++;
            }

            int j = 1;
            while (j <= n) {
                System.out.print("*");
                j += 1;
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
***
 ***
  ***

Sample Input 2:
5

Sample Output 2:
*****
 *****
  *****
   *****
    *****
*/