package assignments;
import java.util.Scanner;

/*
Problem Statement:
Write a program to print triangle of user defined integers sum.
*/

public class SeriesSumPattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int i = 1;
        int sum = 0;

        while (i <= n) {
            int j = 1;
            sum = sum + i;

            while (j <= i) {
                System.out.print(j);
                if (j == i) {
                    System.out.print('=');
                } else {
                    System.out.print('+');
                }
                j++;
            }

            System.out.print(sum);
            System.out.println();
            i++;
        }
    }
}

/*
Sample Input 1:
3

Sample Output 1:
1=1
1+2=3
1+2+3=6

Sample Input 2:
5

Sample Output 2:
1=1
1+2=3
1+2+3=6
1+2+3+4=10
1+2+3+4+5=15
*/