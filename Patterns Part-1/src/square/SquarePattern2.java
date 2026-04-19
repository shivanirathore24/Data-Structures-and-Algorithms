package square;
import java.util.Scanner;

public class SquarePattern2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n) {
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
111
222
333

Sample Input 2:
5
Sample Output 2:
11111
22222
33333
44444
55555
*/