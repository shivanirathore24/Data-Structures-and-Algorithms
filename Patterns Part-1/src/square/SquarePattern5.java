package square;
import java.util.Scanner;

public class SquarePattern5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                System.out.print(n);
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
333
333
333

Sample Input 2:
5
Sample Output 2:
55555
55555
55555
55555
55555
*/