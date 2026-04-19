package triangular;

import java.util.Scanner;

public class TriangularPattern6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        // Method 1: Formula (i - j + 1)
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                System.out.print(i - j + 1);
                j++;
            }
            System.out.println();
            i++;
        }

        // Method 2: Using variable (p--)
        i = 1;
        while (i <= n) {
            int j = 1;
            int p = i;
            while (j <= i) {
                System.out.print(p);
                p--;
                j++;
            }
            System.out.println();
            i++;
        }
    }
}

/*
Sample Input:
3
Sample Output:
1
21
321

Sample Input:
5
Sample Output:
1
21
321
4321
54321
*/