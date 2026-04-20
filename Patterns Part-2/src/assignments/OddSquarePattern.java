package assignments;
import java.util.Scanner;

/*
Problem Statement:
Write a program to print the pattern for the given N number of rows.
*/

public class OddSquarePattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        // i--> currentRow , j--> currentColumn
        int i = 1;
        while (i <= n) {
            int valueToPrint = 2 * i - 1;
            int j = 1;

            while (j <= n) {
                System.out.print(valueToPrint);
                valueToPrint += 2;
                int maxValue = 2 * n - 1;
                if (valueToPrint > maxValue) {
                    valueToPrint = 1;
                }
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
135
351
513

Sample Input 2:
5

Sample Output 2:
13579
35791
57913
79135
91357
*/