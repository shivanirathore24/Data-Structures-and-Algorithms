package triangular;
import java.util.Scanner;

public class TriangularPattern4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int i = 1;
        while (i <= n) {
            int p = i;
            int j = 1;
            while (j <= i) {
                System.out.print(p);
                p++;
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
1
23
345

Sample Input 2:
5
Sample Output 2:
1
23
345
4567
56789
*/