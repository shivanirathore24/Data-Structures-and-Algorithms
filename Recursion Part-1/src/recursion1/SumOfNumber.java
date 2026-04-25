package recursion1;

public class SumOfNumber {
    public static int sumn(int n) {
        if (n == 0) {
            return 0;
        }
        int smallOutput = sumn(n - 1);
        int output = n + smallOutput;
        return output;
    }

    public static void main(String[] args) {
        System.out.println(sumn(5));
    }
}
