package triangular;
import java.util.Scanner;

public class TriangularPattern3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int p = 1;
        int i = 1;
        while (i <= n) {
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
456

Sample Input 2:
5
Sample Output 2:
1
23
456
78910
1112131415
*/