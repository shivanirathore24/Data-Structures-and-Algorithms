package invertedTriangle;
import java.util.Scanner;

public class InvertedTrianglePattern2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n - i + 1) {
                System.out.print(n - i + 1);
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
22
1

Sample Input 2:
5
Sample Output 2:
55555
4444
333
22
1
*/