package assignments;
import java.util.Scanner;

/*
Problem Statement:
Write a program to print N number of rows for Half Diamond pattern using stars and numbers.
*/

public class HalfDiamondPattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("*");

        // first half
        for (int i = 1; i <= n; i++) {
            System.out.print("*");
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int k = i - 1; k >= 1; k--) {
                System.out.print(k);
            }
            System.out.print("*");
            System.out.println();
        }

        // second half
        for (int i = n; i > 1; i--) {
            System.out.print("*");
            for (int j = 1; j < i; j++) {
                System.out.print(j);
            }
            for (int k = i - 2; k >= 1; k--) {
                System.out.print(k);
            }
            System.out.print("*");
            System.out.println();
        }
        System.out.println("*");
    }
}

/*
Sample Input 1:
3

Sample Output 1:
*
*1*
*121*
*12321*
*121*
*1*
*

Sample Input 2:
5

Sample Output 2:
*
*1*
*121*
*12321*
*1234321*
*123454321*
*1234321*
*12321*
*121*
*1*
*
*/