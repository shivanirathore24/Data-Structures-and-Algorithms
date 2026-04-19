package square;
import java.util.Scanner;

public class SquarePattern3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                System.out.print(j);
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
123
123
123

Sample Input 2:
5
Sample Output 2:
12345
12345
12345
12345
12345
*/