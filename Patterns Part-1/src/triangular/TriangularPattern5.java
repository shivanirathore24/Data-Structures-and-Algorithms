package triangular;
import java.util.Scanner;

public class TriangularPattern5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                System.out.print(i);
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
22
333

Sample Input 2:
5
Sample Output 2:
1
22
333
4444
55555
*/